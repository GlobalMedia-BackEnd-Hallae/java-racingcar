package View;

import Model.Car;

import java.util.List;

public class ProcessOutput {

    public void outputCarDistance(int number) {
        for (int distance = 0; distance < number; distance++) {
            System.out.print("-");
        }
    }

    public void processOutput(List<Car> carClassList) {
        for (int index = 0; index < carClassList.size(); index++) {
            System.out.print(carClassList.get(index).carName() + " : ");
            outputCarDistance(carClassList.get(index).carPosition());
            System.out.println();
        }

        System.out.println();
    }
}
