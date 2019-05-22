package coordinate.view;

import coordinate.controller.CoordinateController;
import coordinate.domain.Line;
import coordinate.domain.Point;
import coordinate.domain.Vector2;
import coordinate.messageConstants.MessageConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    private static final int LEN_DIGITS = 2;
    private static final int MAX_NUM = 24;
    private static final int VERTICAL_START = 1;
    private static final int HORIZON_START = LEN_DIGITS;

    public void run() {
        List<Point> points = CoordinateController.getCoordinates();

        printCoordinatesBoard(points);

        printResult(new Line(points.get(0), points.get(1)));
    }

    private void printResult(Line lines) {
        System.out.printf(MessageConstants.LINE_RESULT_FORMAT, lines.length());
    }

    private void printCoordinatesBoard(List<Point> points) {
        List<List<Character>> board = initBoard();

        drawVerticalLine(board);
        drawHorizontalLine(board);
        drawZero(board);

        drawPnts(board, points, '*');

        printBoard(board);
    }

    private List<List<Character>> initBoard() {
//        List<Character> line = Stream.generate(() -> ' ')
//                .limit(LEN_DIGITS * (2 + (MAX_NUM+1)))
//                .collect(Collectors.toList());
//
//        return Stream.generate(() -> new ArrayList(line)).limit(1 + (MAX_NUM + 1)).collect(Collectors.toList());


        return Stream.generate(() -> Stream.generate(() -> ' ')
                .limit(LEN_DIGITS * (2 + (MAX_NUM+1)))
                .collect(Collectors.toList())).limit(1 + (MAX_NUM + 1)).collect(Collectors.toList());
    }

    private void set(List<List<Character>> board, int r, int c, char ch) {
        List<Character> line = board.get(r);
        line.set(c, ch);
    }

    private void drawVerticalLine(List<List<Character>> board) {
        for (int r = 0; r <= MAX_NUM; r++) {
            set(board, VERTICAL_START + r, HORIZON_START, '|');
        }

        for (int r = 2; r <= MAX_NUM; r += 2) {
            int num = r;

            for (int i = LEN_DIGITS - 1; 0 <= i; i--, num /= 10) {
                if (num == 0) {
                    break;
                }
                set(board, VERTICAL_START + r, i, (char)('0' + (num % 10)));
            }
        }
    }

    private void drawHorizontalLine(List<List<Character>> board) {
        for (int c = 0; c <= MAX_NUM; c++) {
            for (int i = 0; i < LEN_DIGITS; i++) {
                set(board, VERTICAL_START, HORIZON_START + (c * LEN_DIGITS) + i, '-');
            }
        }

        for (int c = 2; c <= MAX_NUM; c += 2) {
            int num = c;
            for (int i = LEN_DIGITS - 1; 0 <= i; i--,num /= 10) {
                if (num == 0) {
                    break;
                }
                set(board, VERTICAL_START-1, HORIZON_START + (c * LEN_DIGITS)+i, (char)('0' + (num % 10)));
            }
        }
    }

    private void drawZero(List<List<Character>> board) {
        set(board, 0, 0, '0');
        set(board, VERTICAL_START, HORIZON_START, '+');
    }

    private void drawPnts(List<List<Character>> board, List<Point> points, char ch) {
        for (Point point : points) {
            Vector2 v = point.getVector2();
            set(board, VERTICAL_START + v.getY(), HORIZON_START + (LEN_DIGITS * v.getX()), ch);
        }
    }

    private void printBoard(List<List<Character>> board) {
        for (int r = board.size() - 1; 0 <= r; r--) {
            StringBuilder sb = new StringBuilder();

            for (Character ch : board.get(r)) {
                sb.append(ch);
            }
            System.out.println(sb.toString());
        }
        System.out.println();
    }



}
