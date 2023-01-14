package gmbs.model;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car move(int position) {
        Car car = new Car(this.name);
        car.position = position;
        return car;
    }

    public String carName() {
        return this.name;
    }

    public int carPosition() {
        return this.position;
    }
}
