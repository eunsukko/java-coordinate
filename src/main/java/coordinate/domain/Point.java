package coordinate.domain;

import java.util.Objects;

public class Point {
    private final Number x;
    private final Number y;

    public Point(Number x, Number y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException("null 입력");
        }
        this.x = x;
        this.y = y;
    }

    public Number getX() {
        return x;
    }

    public Number getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Vector2 subtract(Point p2) {
        return new Vector2(x.getNumber() - p2.getX().getNumber(), y.getNumber() - p2.getY().getNumber());
    }
}
