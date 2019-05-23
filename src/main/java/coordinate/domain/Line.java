package coordinate.domain;

import coordinate.messageConstants.MessageConstants;

import java.util.List;

public class Line implements ResultPrintable {
    private final Point a;
    private final Point b;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public static Line create(Point p1, Point p2) {
        return new Line(p1, p2);
    }

    public double length() {
        return a.subtract(b).length();
    }

    @Override
    public String getResultMessage() {
        return String.format(MessageConstants.LINE_RESULT_FORMAT, length());
    }


    public static ResultPrintable create(List<Point> points) {
        return new Line(points.get(0), points.get(1));
    }
}
