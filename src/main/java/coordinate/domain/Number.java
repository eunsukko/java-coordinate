package coordinate.domain;

import coordinate.messageConstants.MessageConstants;

import java.util.Objects;

public class Number {
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 24;

    private final int number;

    private Number(int number) {
        if (!(MIN_NUM <= number && number <= MAX_NUM)) {
            throw new IllegalArgumentException(MessageConstants.ERROR_OUT_OF_BOUND);
        }
        this.number = number;
    }

    public static Number create(int number) {
        return new Number(number);
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
