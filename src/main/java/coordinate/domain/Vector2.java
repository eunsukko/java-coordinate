package coordinate.domain;

import java.util.Objects;

public class Vector2 {
    private final int x;
    private final int y;

    private Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2 create(int x, int y) {
        return new Vector2(x, y);
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector2 minus(Vector2 v) {
        return new Vector2(x - v.x, y - v.y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2 vector2 = (Vector2) o;
        return x == vector2.x &&
                y == vector2.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
