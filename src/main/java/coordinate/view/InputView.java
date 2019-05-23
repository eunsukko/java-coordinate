package coordinate.view;

import coordinate.domain.Point;
import coordinate.domain.PointList;
import coordinate.messageConstants.MessageConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCAN = new Scanner(System.in);

    public PointList inputCoordinates() {
        System.out.println(MessageConstants.INPUT_COORDINATES);
        String input = SCAN.nextLine();

        try {
            return PointList.create(inputToPoints(input));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputCoordinates();
        }
    }

    private List<Point> inputToPoints(String input) {
        input = input.replace(MessageConstants.POINT_SEPARATOR, MessageConstants.NUMBER_SEPARATOR);
        input = input.replace(MessageConstants.START_POINT, MessageConstants.EMPTY);
        input = input.replace(MessageConstants.END_POINT, MessageConstants.EMPTY);

        List<Integer> nums = Arrays.asList(input.split(MessageConstants.NUMBER_SEPARATOR))
                .stream()
                .mapToInt(str -> Integer.parseInt(str))
                .boxed().collect(Collectors.toList());

        return numbersToPoints(nums);
    }

    private List<Point> numbersToPoints(List<Integer> numbers) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i += 2) {
            points.add(Point.create(numbers.get(i), numbers.get(i + 1)));
        }

        return points;
    }
}
