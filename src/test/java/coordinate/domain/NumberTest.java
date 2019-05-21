package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberTest {
    @Test
    void 생성자_() {}

    @Test
    void 생성자_좌표가_24이상일때() {
        assertThrows(IllegalArgumentException.class, () -> new Number(25));
    }

    @Test
    void 생성자_좌표가_음수일때() {
        assertThrows(IllegalArgumentException.class, () -> new Number(-1));
    }

    @Test
    void 정상() {
        Number point = new Number(10);
        assertThat(point).isEqualTo(new Number(10));
    }

}
