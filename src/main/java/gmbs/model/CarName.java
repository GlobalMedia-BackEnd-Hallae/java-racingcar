package gmbs.model;

public class CarName {

    private static final int LENGTH_THRESHOLD = 5;
    private final String name;

    public CarName(String carName) {
        validateLength(carName);
        this.name = carName;
    }

    private void validateLength(String name) {
        if (name.length() > LENGTH_THRESHOLD || name.length() == 0) {
            throw new IllegalArgumentException("[Error] 이름은 1자 이상 5자 이하여야 한다.");
        }
        if (name.contains(" ")) {
            throw new IllegalArgumentException("[Error] 공백 금지");
        }
    }

    public String name() {
        return this.name;
    }
}
