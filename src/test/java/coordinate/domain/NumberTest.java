package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberTest {
    @Test
    void 생성자_좌표가_24이상일때() {
        assertThrows(IllegalArgumentException.class, () -> Number.create(25));
    }

    @Test
    void 생성자_좌표가_음수일때() {
        assertThrows(IllegalArgumentException.class, () -> Number.create(-1));
    }

    @Test
    void 생성자_좌표가_정상범위에_있을때() {
        Number point = Number.create(10);
        assertThat(point).isEqualTo(Number.create(10));
    }


}
