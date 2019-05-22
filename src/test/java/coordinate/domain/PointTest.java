package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    void subtract_() {
        Point p1 = Point.create(1, 1);
        Point p2 = Point.create(0, 0);

        assertThat(p1.subtract(p2)).isEqualTo(Vector2.create(1, 1));
    }
}