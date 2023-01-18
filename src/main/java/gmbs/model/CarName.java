package gmbs.model;

public class CarName {

    private static final int LENGTH_THRESHOLD = 5;
    private final String name;

    public CarName(String carName) {
        this.name = carName;
        validateLength();
    }

    private void validateLength() {
        if (this.name.length() > LENGTH_THRESHOLD || this.name.length() == 0) {
            throw new IllegalArgumentException("[Error] 이름은 1자 이상 5자 이하여야 한다.");
        }
        if (this.name.contains(" ")) {
            throw new IllegalArgumentException("[Error] 공백 금지");
        }
    }

    public String name() {
        return this.name;
    }
}
