package coordinate.domain;

import coordinate.messageConstants.MessageConstants;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rectangles implements Figure, ResultPrintable {
    private final List<Point> points;

    public Rectangles(List<Point> points) {
        if (!isRectangles(points)) {
            throw new IllegalArgumentException();
        }

        this.points = points;
    }

    private boolean isRectangles(List<Point> points) {
        return checkX(points) && checkY(points);
    }

    private boolean checkX(List<Point> points) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (Point point : points) {
            //counter.put(point.getVector2().getX(), )
            int x = point.getVector2().getX();
            int count = 0;

            if (!counter.containsKey(x)) {
                counter.put(x, 1);
            } else {
                count = counter.get(x);
                counter.put(x, count + 1);
            }
        }

        for (int x : counter.keySet()) {
            if (counter.get(x) != 2) {
                return false;
            }
        }

        return true;
    }


    private boolean checkY(List<Point> points) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (Point point : points) {
            //counter.put(point.getVector2().getX(), )
            int y = point.getVector2().getY();
            int count = 0;

            if (!counter.containsKey(y)) {
                counter.put(y, 1);
            } else {
                count = counter.get(y);
                counter.put(y, count + 1);
            }
        }

        for (int y : counter.keySet()) {
            if (counter.get(y) != 2) {
                return false;
            }
        }

        return true;
    }

    public static Rectangles create(Point p1, Point p2, Point p3, Point p4) {
        List<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);

        return new Rectangles(points);
    }

    @Override
    public double area() {
        double height = 0;
        double width = 0;

        for (int i = 1; i < points.size(); i++) {
            if (points.get(0).getVector2().getX() == points.get(i).getVector2().getX()) {
                height = points.get(0).subtract(points.get(i)).length();
            }

            if (points.get(0).getVector2().getY() == points.get(i).getVector2().getY()) {
                width = points.get(0).subtract(points.get(i)).length();
            }
        }

        return width * height;
    }

    @Override
    public String getResultMessage() {
        return String.format(MessageConstants.RECTANGLES_RESULT_FORMAT, area());
    }

    public static ResultPrintable create(List<Point> points) {
        return new Rectangles(points);
    }
}
