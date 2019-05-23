package coordinate.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class PointList {
    private final List<Point> points;

    private PointList(List<Point> points) {
        Set<Point> set = new HashSet<>(points);
        if (points.size() != set.size()) {
            throw new IllegalArgumentException("중복된 점이 있습니다.");
        }
        this.points = points;
    }

    public static PointList create(List<Point> points) {
        return new PointList(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointList pointList = (PointList) o;
        return Objects.equals(points, pointList.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    public List<Point> getPoints() {
        return points;
    }
}
