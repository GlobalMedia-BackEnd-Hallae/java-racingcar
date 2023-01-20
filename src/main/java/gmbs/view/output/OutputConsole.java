package gmbs.view.output;

import gmbs.model.car.Car;

import java.util.List;

public interface OutputConsole {
    void printRoundResult(List<Car> cars);

    void printEndResult(List<String> carNames);
}
