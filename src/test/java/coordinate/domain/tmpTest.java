package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class tmpTest {
    @Test
    void tmp() {
        // (10,10)-(14,15)
        String inp = "(10,10)-(14,15)";

        inp = inp.replace('-', ',');

        // ,10,10)-,14,15)

        inp = inp.replace("(", "");
        inp = inp.replace(")", "");

        // ,10,10,14,15
        List<Integer> nums = Arrays.asList(inp.split(","))
                .stream()
                .mapToInt(str -> Integer.parseInt(str))
                .boxed().collect(Collectors.toList());


        // 10, 10, 14, 15
        assertThat(nums).isEqualTo(Arrays.asList(10, 10, 14, 15));
    }

}
