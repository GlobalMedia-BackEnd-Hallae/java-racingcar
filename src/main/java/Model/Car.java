package Model;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int advance) {
        this.position += advance;
    }

    public String carName() {
        return this.name;
    }

    public int carPosition() {
        return this.position;
    }
}
