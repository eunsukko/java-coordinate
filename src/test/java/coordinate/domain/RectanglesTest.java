package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectanglesTest {
    @Test
    void 넓이구하기() {
        Rectangles rectangles = Rectangles.create(Point.create(10,10),Point.create(22,10),
                Point.create(22,18), Point.create(10,18));
        assertThat(rectangles.getArea()).isEqualTo(96,offset(0.00099));
    }

    @Test
    void 넓이구하기2() {
        Rectangles rectangles = Rectangles.create(Point.create(10,10),Point.create(12,10),
                Point.create(12,12), Point.create(10,12));
        assertThat(rectangles.getArea()).isEqualTo(4,offset(0.00099));
    }

    @Test
    void 넓이구하기3() {
        Rectangles rectangles = Rectangles.create(Point.create(10,10),Point.create(22,18),
                Point.create(22,10), Point.create(10,18));
        assertThat(rectangles.getArea()).isEqualTo(96,offset(0.00099));
    }

    @Test
    void 사각형인지_확인() {

        assertThrows(IllegalArgumentException.class, () -> {
            Rectangles rectangles = Rectangles.create(Point.create(10,15),Point.create(17,15),
                    Point.create(19,22), Point.create(26,22));
        });
    }
}
