package coordinate.domain;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Points {
    private final List<Point> points;

    private Points(List<Point> points) {
        this.points = points;
    }

    public static Points from(List<Point> points) {
        return new Points(points);
    }

    public Point get(int i) {
        return points.get(i);
    }

    public Point find(Predicate<Point> predicate) {
        return points.stream().filter(predicate).findFirst().get();
    }

    public List<Point> toList() {
        return Collections.unmodifiableList(points);
    }

    public int size() {
        return points.size();
    }

    public double distance(int from, int to) {
        Point p1 = points.get(from);
        Point p2 = points.get(to);
        Vector2 v = p1.subtract(p2);

        return v.length();
    }
}
