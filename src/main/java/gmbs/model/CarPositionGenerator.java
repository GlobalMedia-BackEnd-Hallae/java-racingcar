package gmbs.model;

public class CarPositionGenerator {
    private static final ForwardStatusGenerator statusGenerator = new ForwardStatusGenerator();
    private static final int TRAVEL_DISTANCE = 1;
    private static final int RANGE_START = 0;
    private static final int RANGE_END = 9;
    private static final int REFERENCE_CONDITION = 4;

    public Car updatePosition(Car car) {
        if (statusGenerator.isMoveForward(RANGE_START, RANGE_END, REFERENCE_CONDITION)) {
            return car.move(TRAVEL_DISTANCE);
        }
        return car;
    }
}
