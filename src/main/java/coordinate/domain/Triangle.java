package coordinate.domain;

import coordinate.messageConstants.MessageConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class Triangle implements Figure, ResultPrintable {
    private List<Point> points;

    private Triangle(List<Point> points) {
        this.points = points;
    }

    public static Triangle create(Point p1, Point p2, Point p3) {
        List<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);

        return new Triangle(points);
    }

    @Override
    public double area() {
        List<Double> lens = new ArrayList<>();
        double s = 0;
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size());

            double len = p1.subtract(p2).length();

            lens.add(len);
            s += len;
        }
        s = s / 2;

        double mul = s;
        for (Double len : lens) {
            mul *= (s - len);
        }

        return Math.sqrt(mul);
    }

    @Override
    public String getResultMessage() {
        return String.format(MessageConstants.TRIANGLE_RESULT_FORMAT, area());
    }


    public static ResultPrintable create(List<Point> points) {
        // 점 개수를 확인 안함...
        return new Triangle(points);
    }
}
