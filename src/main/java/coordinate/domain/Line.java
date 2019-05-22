package coordinate.domain;

public class Line {
    private final Point a;
    private final Point b;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public double length() {
        return a.subtract(b).length();
    }
}
