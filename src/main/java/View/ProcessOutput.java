package view;

import model.Car;

import java.util.List;

public class ProcessOutput {

    public void outputCarDistance(int number) {
        for (int distance = 0; distance < number; distance++) {
            System.out.print("-");
        }
    }

    public void processOutput(List<Car> carStatus) {
        for (Car car : carStatus) {
            System.out.print(car.carName() + " : ");
            outputCarDistance(car.carPosition());
            System.out.println();
        }

        System.out.println();
    }
}
