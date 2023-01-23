package model;

public class CarName {

    private final String name;

    public CarName(String name) {
        final int CAR_NAME_MIN_LIMIT = 1;
        final int CAR_NAME_MAX_LIMIT = 5;

        if (name.length() < CAR_NAME_MIN_LIMIT || name.length() > CAR_NAME_MAX_LIMIT) {
            throw new IllegalStateException();
        }

        this.name = name;
    }

    public String getCarName() {
        return name;
    }
}
