package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class LineTest {
    @Test
    void 선_길이_구하기_1() {
        Line line = new Line(Point.create(0, 0), Point.create(1, 1));
        assertThat(line.length()).isEqualTo(1.414, offset(0.00099));
    }

    @Test
    void 선_길이_구하기_2() {
        Line line = new Line(Point.create(0, 0), Point.create(1, 2));
        assertThat(line.length()).isEqualTo(2.236, offset(0.00099));
    }

    @Test
    void 선_길이_구하기_3() {
        Line line = new Line(Point.create(10, 10), Point.create(14, 15));
        assertThat(line.length()).isEqualTo(6.403124, offset(0.00099));
    }
}
