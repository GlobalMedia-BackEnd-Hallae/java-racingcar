package gmbs.model;

public class Car {
    private final CarName carName;
    private int position = 0;

    public Car(String name) {
        this.carName = new CarName(name);
    }

    public Car move(int position) {
        Car car = new Car(carName.name());
        car.position = position;
        return car;
    }

    public String carName() {
        return this.carName.name();
    }

    public int carPosition() {
        return this.position;
    }
}
