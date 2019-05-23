package coordinate.domain;

import java.awt.print.Printable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultPrintableFactory {
    private static final Map<Integer, FigureCreator> printables = createMap();

    private static Map<Integer, FigureCreator> createMap() {
        Map<Integer, FigureCreator> result = new HashMap<Integer, FigureCreator>();
        result.put(2, Line::create);
        result.put(3, Triangle::create);
        result.put(4, Rectangles::create);
        return Collections.unmodifiableMap(result);
    }

    ;

    public static ResultPrintable create(List<Point> points) {
//        if (points.size() == 2) {
//            return Line.create(points.get(0), points.get(1));
//        }
//
//        if (points.size() == 3) {
//            return Triangle.create(points.get(0), points.get(1), points.get(2));
//        }
//
//        if (points.size() == 4) {
//            return Rectangles.create(points.get(0), points.get(1), points.get(2), points.get(3));
//        }
//
//        printables.get(size)
        FigureCreator func = printables.get(points.size());


        return func.create(points);


        // throw new UnsupportedOperationException();
    }
}
