package coordinate.domain;

public abstract class AbstractFigure implements Figure {
    private final Points points;

    AbstractFigure(Points points) {
        validateNotDuplicatedPoints(points);
        this.points = points;
    }

    private void validateNotDuplicatedPoints(Points points) {
        if (DuplicationChecker.hasDuplication(points.toList())) {
            throw new IllegalArgumentException(String.format("%d개의 점중에서 중복된 점이 존재합니다.", points.size()));
        }
    }

    @Override
    public String getMessage() {
        return String.format("%s의 %s는 %.6f 입니다.", getFigureName(), getMeasureUnitName(), measure());
    }

    public Points getPoints() {
        return points;
    }

    abstract String getFigureName();

    abstract String getMeasureUnitName();

    abstract double measure();
}
