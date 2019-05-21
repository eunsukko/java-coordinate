package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class LineTest {

    @Test
    void length_선_길이_구하기() {
        Line line = new Line(new Point(new Number(0), new Number(0)), new Point(new Number(1), new Number(1)));
        assertThat(line.length()).isEqualTo(1.414, offset(0.00099));
    }

    @Test
    void error_선_길이_구하기() {
        Line line = new Line(new Point(new Number(0), new Number(0)), new Point(new Number(1), new Number(2)));
        // 2.23606797749979 , sqrt(1 + 4)
        assertThat(line.length()).isEqualTo( 2.236, offset(0.00099));
    }

    @Test
    void error_선_길이_구하기2() {
        Line line = new Line(new Point(new Number(10), new Number(10)), new Point(new Number(14), new Number(15)));
        assertThat(line.length()).isEqualTo( 6.403124, offset(0.00099));
    }
}
