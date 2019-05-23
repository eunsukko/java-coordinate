package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointListTest {
    @Test
    void 생성자_중복있는지() {
        List<Point> points = Arrays.asList(Point.create(0,0), Point.create(0,0));

        assertThrows(IllegalArgumentException.class, () -> PointList.create(points));
    }

    @Test
    void 생성자_중복없을때() {
        List<Point> points = Arrays.asList(Point.create(0,0), Point.create(0,1));

        assertThat(PointList.create(points)).isEqualTo(PointList.create(points));
    }
}
