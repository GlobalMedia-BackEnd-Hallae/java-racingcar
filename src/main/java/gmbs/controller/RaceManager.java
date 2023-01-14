package gmbs.controller;

import gmbs.model.Car;
import gmbs.view.Display;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {
    private final Display display = new Display();
    private final CarStatusReader reader = new CarStatusReader();
    private final CarManager manager = new CarManager();

    public List<Car> doRace(List<Car> currentStatus, int repeatCount) {
        List<Car> resultStatus = new ArrayList<>(currentStatus);
        for (int i = 0; i < repeatCount; i++) {
            resultStatus = manager.updateStatus(resultStatus);
            display.showStatus(reader.readCurrentStatus(resultStatus));
        }
        return resultStatus;
    }

    private List<String> headPositionNames(List<Car> cars) {
        return new ArrayList<>(reader.readHeadPositionNames(cars));
    }

    public void showWinners(List<Car> cars) {
        display.showWinners(headPositionNames(cars));
    }
}
