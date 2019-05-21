package coordinate.domain;

public class Line {
    private final Point a;
    private final Point b;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public double length() {
        Vector2 vector2 = a.subtract(b);
        Vector2 v = vector2.multiply(vector2);
        return Math.sqrt(v.getX() + v.getY());
    }

    //1단계 결과, 출력하는거!
}
