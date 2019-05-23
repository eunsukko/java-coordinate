package coordinate.domain;

import coordinate.messageConstants.MessageConstants;

import java.util.Objects;

public class Point {
    private final Number x;
    private final Number y;

    private Point(Number x, Number y) {
        if (Objects.isNull(x) || Objects.isNull(y)) {
            throw new IllegalArgumentException(MessageConstants.ERROR_NULL);
        }
        this.x = x;
        this.y = y;
    }

    public static Point create(int x, int y) {
        return new Point(Number.create(x), Number.create(y));
    }

    public Vector2 getVector2() {
        return Vector2.create(x.getNumber(), y.getNumber());
    }

    public Vector2 subtract(Point p2) {
        return getVector2().minus(p2.getVector2());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x.equals(point.x) &&
                y.equals(point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
