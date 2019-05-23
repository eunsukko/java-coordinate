package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {

    @Test
    void 넓이구하기() {
        // (10,10)-(14,15)-(20,8)
        Triangle triangle = Triangle.create(Point.create(10, 10), Point.create(14, 15), Point.create(20, 8));
        assertThat(triangle.getArea()).isEqualTo(29,offset(0.00099));
    }

    @Test
    void 넓이구하기2() {
        Triangle triangle = Triangle.create(Point.create(0, 0), Point.create(4, 0), Point.create(0, 4));
        assertThat(triangle.getArea()).isEqualTo(8,offset(0.00099));
    }
//
//    @Test
//    void 넓이구하기3() {
//        Rectangles rectangles = Rectangles.create(Point.create(10,10),Point.create(22,18),
//                Point.create(22,10), Point.create(10,18));
//        assertThat(rectangles.getArea()).isEqualTo(96,offset(0.00099));
//    }
}
