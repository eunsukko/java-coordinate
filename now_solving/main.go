package main

import "fmt"

var lenDigits = 2
var maxNum = 24

var verticalStart = 1
var horizonStart = lenDigits

var board [][]byte

func initBoard() {
	board = make([][]byte, 1+(maxNum+1))
	for r := range board {
		board[r] = make([]byte, lenDigits*(2+(maxNum+1)))
	}

	for r := range board {
		for c := range board[r] {
			board[r][c] = ' '
		}
	}
}

func drawVerticalLine() {
	for r := 0; r <= maxNum; r++ {
		board[verticalStart+r][horizonStart] = '|'
	}

	for r := 2; r <= maxNum; r += 2 {
		// fill number
		// 뒤에서 부터 입력
		num := r
		for c := lenDigits - 1; 0 <= c; c-- {
			if num == 0 {
				break
			}
			board[verticalStart+r][c] = byte('0' + (num % 10))
			num /= 10
		}
	}
}

func drawHorizontalLine() {
	for c := 0; c <= maxNum; c++ {
		for i := 0; i < lenDigits; i++ {
			board[verticalStart][horizonStart+(c*lenDigits)+i] = '-'
		}
	}

	for c := 2; c <= maxNum; c += 2 {
		num := c
		for i := lenDigits - 1; 0 <= i; i-- {
			if num == 0 {
				break
			}
			board[verticalStart-1][horizonStart+(lenDigits*c)+i] = byte('0' + (num % 10))
			num /= 10
		}

	}
}

func drawZero() {
	board[0][0] = '0'
	board[verticalStart][horizonStart] = '+'
}

func printBoard() {
	for r := len(board) - 1; 0 <= r; r-- {
		fmt.Println(string(board[r]))
	}
}

type Pnt struct {
	r, c int
}

func drawPnts(pnts []Pnt, ch byte) {
	for _, pnt := range pnts {
		board[verticalStart+pnt.r][horizonStart+(lenDigits*pnt.c)] = ch
	}
}

func main() {
	initBoard()

	drawVerticalLine()
	drawHorizontalLine()
	drawZero()

	pnts := []Pnt{
		Pnt{2, 2},
		Pnt{12, 12},
		Pnt{24, 24},
	}
	drawPnts(pnts, '*')

	printBoard()
}
