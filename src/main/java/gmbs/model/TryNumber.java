package gmbs.model;

import java.util.Objects;

public class TryNumber {
    private final int tryNumber;
    public static final String TRY_NUMBER_NOT_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 시도할 횟수는 숫자여야 합니다.";
    public static final String TRY_NUMBER_NOT_NATURAL_NUMBER_MESSAGE = "[ERROR] 시도할 횟수는 자연수여야 합니다.";

    public TryNumber(String countString) {
        this.tryNumber = convertStringToInt(countString);
        validatePositive(tryNumber);
    }

    public boolean isNotSame(int tryCount) {
        return this.tryNumber != tryCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TryNumber tryNumber1 = (TryNumber) obj;
        return tryNumber == tryNumber1.tryNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryNumber);
    }

    private int convertStringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_NUMBER_NOT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void validatePositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(TRY_NUMBER_NOT_NATURAL_NUMBER_MESSAGE);
        }
    }
}
