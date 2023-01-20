package gmbs.model.car.vo;

import java.util.Objects;

public class Name {

    private static final int MAX_LENGTH_OF_CAR_NAME = 5;

    private final String value;

    public Name(final String value) {
        checkName(value);
        this.value = value;
    }

    private void checkName(String value) {
        if (value.length() > MAX_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자를 넘길 수 없습니다");
        }
        if (value.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백일 수 없습니다. 다시 입력하세요");
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
