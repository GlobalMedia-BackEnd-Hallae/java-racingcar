package gmbs.model;

import java.util.Objects;

public class TryNumber {
    private final int tryNumber;
    private static final int TRY_MAX_CNT = 100;
    private static final String TRY_NUMBER_NOT_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 시도할 횟수는 숫자여야 합니다.";
    private static final String TRY_NUMBER_NOT_VALID_NUMBER_MESSAGE = "[ERROR] 시도할 횟수는 100번 이하입니다";

    public TryNumber(String countString) {
        validateStringIsNumber(countString);
        isValidNumber(countString);
        this.tryNumber = convertStringToInt(countString);
    }

    public boolean isNotSame(int tryNumber) {
        return this.tryNumber != tryNumber;
    }

    private void validateStringIsNumber(String input) {
        if (!input.matches("[0-9]")) {
            throw new IllegalArgumentException(TRY_NUMBER_NOT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void isValidNumber(String input) {
        long count = Long.parseLong(input);
        if (count < 0 || count > TRY_MAX_CNT) {
            throw new IllegalArgumentException(TRY_NUMBER_NOT_VALID_NUMBER_MESSAGE);
        }
    }

    private int convertStringToInt(String string) {
        return Integer.parseInt(string);
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
}
