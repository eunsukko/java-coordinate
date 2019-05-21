package coordinate.domain;

import java.util.Objects;

public class Number {
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 24;

    private final int number;

    public Number(int number) {
        if (number > 24 || number < 0) {
            throw new IllegalArgumentException("error");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
