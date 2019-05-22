package coordinate.view;

import coordinate.controller.CoordinateController;
import coordinate.domain.Line;
import coordinate.domain.Point;
import coordinate.messageConstants.MessageConstants;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    public void run() {
        List<Point> points = CoordinateController.getCoordinates();

        printResult(new Line(points.get(0), points.get(1)));
    }

    private void printResult(Line lines) {
        System.out.printf(MessageConstants.LINE_RESULT_FORMAT, lines.length());
    }
}
