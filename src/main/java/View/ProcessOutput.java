package view;

import model.Car;

import java.util.List;

public class ProcessOutput {

    public void processOutput(List<Car> carStatus) {
        final String COLON = " : ";
        final String ENTER = "\n";

        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : carStatus) {
            stringBuilder.append(car.carName() + COLON + carDistanceOutput(car.carPosition()) + ENTER);
        }

        System.out.println(stringBuilder);
    }

    private StringBuilder carDistanceOutput(int distance) {
        final String DISTANCE = "-";

        StringBuilder stringBuilder = new StringBuilder();

        for (int index = 0; index < distance; index++) {
            stringBuilder.append(DISTANCE);
        }

        return stringBuilder;
    }
}
