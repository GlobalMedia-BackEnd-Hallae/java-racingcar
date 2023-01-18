package gmbs.controller;

import gmbs.model.Car;
import gmbs.view.Display;
import gmbs.view.UserInput;

import java.util.ArrayList;
import java.util.List;

public class CarRaceOperator {
    private static final Display display = new Display();
    private static final UserInput userInput = new UserInput();
    private static final InputManager inputManager = new InputManager();
    private static final CarManager carManager = new CarManager();
    private static final CarStatusReader reader = new CarStatusReader();

    private int scanRepetition() {
        int repetition;

        try {
            repetition = inputManager.repetitionInput(userInput.userInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            repetition = scanRepetition();
        }
        return repetition;
    }

    public void operateCarRace() {
        List<Car> cars;
        int repetition;

        display.showStartDisplay();
        cars = scanCars();
        display.showRepeatDisplay();
        repetition = scanRepetition();
        cars = repeatRace(cars, repetition);
        display.showWinners(reader.readHeadPositionNames(cars));
    }

    private List<Car> scanCars() {
        List<Car> cars;
        List<String> carNames;
        try {
            carNames = inputManager.carNameInput(userInput.userInput());
            cars = carManager.createCar(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            cars = scanCars();
        }
        return cars;
    }

    private List<Car> repeatRace(List<Car> currentStatus, int repeatCount) {
        List<Car> resultStatus = new ArrayList<>(currentStatus);
        for (int i = 0; i < repeatCount; i++) {
            resultStatus = carManager.updateStatus(resultStatus);
            display.showStatus(reader.readCurrentStatus(resultStatus));
        }
        return resultStatus;
    }
}
