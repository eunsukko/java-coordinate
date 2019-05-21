package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @Test
    void 생성자_null입력() {
        assertThrows(IllegalArgumentException.class, () -> new Point(null, null));
    }

    @Test
    void subtract_() {
        Point p1 = new Point(new Number(1), new Number(1));
        Point p2 = new Point(new Number(0), new Number(0));

        assertThat(p1.subtract(p2)).isEqualTo(new Vector2(1, 1));
    }
}