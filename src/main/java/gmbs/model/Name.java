package gmbs.model;

import java.util.Objects;

public class Name {
    private static final int MAX_LENGTH = 5;
    private static final String EMPTY_NAME_MESSAGE = "[ERROR] 이름은 빈 값으로 입력할 수 없습니다.";
    private static final String LONG_NAME_MESSAGE = "[ERROR] 5글자를 초과하는 이름이 존재합니다.";
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNotBlank(name);
        validateLength(name);
    }

    private void validateNotBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(EMPTY_NAME_MESSAGE);
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(LONG_NAME_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Name name1 = (Name) obj;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
