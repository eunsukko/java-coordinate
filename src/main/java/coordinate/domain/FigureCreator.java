package coordinate.domain;

import java.util.List;

@FunctionalInterface
public interface FigureCreator {
    ResultPrintable create(List<Point> points);
}
