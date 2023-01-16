package gmbs.model.car.vo;

public class Name {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String BLANK = "\\s";

    private final String value;

    public Name(final String value) {
        checkName(value);
        this.value = value;
    }

    private void checkName(String value) throws IllegalArgumentException {
        if (value.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자를 넘길 수 없습니다");
        }
        if (value.matches(BLANK)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백일 수 없습니다. 다시 입력하세요");
        }
    }

    public String getValue() {
        return value;
    }
}
