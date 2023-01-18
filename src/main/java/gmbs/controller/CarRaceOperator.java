package gmbs.controller;

import gmbs.model.Car;
import gmbs.model.Dice;
import gmbs.model.RepetitionNumber;
import gmbs.view.Display;
import gmbs.view.UserInput;

import java.util.ArrayList;
import java.util.List;

public class CarRaceOperator {
    private static final Display display = new Display();
    private static final UserInput userInput = new UserInput();
    private static final InputConverter inputManager = new InputConverter();
    private static final CarStatusReader reader = new CarStatusReader();
    private static final String SPLIT_VALUE = ",";
    private static final Dice dice = new Dice(0, 9);

    private List<Car> createCar(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private List<Car> updateCarsStatus(List<Car> currentStatus) {
        List<Car> updateStatus = new ArrayList<>();
        for (Car car : currentStatus) {
            updateStatus.add(car.moveByCondition(dice.roll()));
        }
        return updateStatus;
    }

    private int scanRepetition() {
        int repetition;
        try {
            repetition = Integer.parseInt(new RepetitionNumber(userInput.userInput()).number());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            repetition = scanRepetition();
        }
        return repetition;
    }

    private List<Car> registerCars() {
        List<Car> cars;
        List<String> carNames;
        try {
            carNames = inputManager.splitInputBy(userInput.userInput(), SPLIT_VALUE);
            cars = createCar(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            cars = registerCars();
        }
        return cars;
    }

    private List<Car> repeatRace(List<Car> currentStatus, int repeatCount) {
        List<Car> resultStatus = new ArrayList<>(currentStatus);
        for (int i = 0; i < repeatCount; i++) {
            resultStatus = updateCarsStatus(resultStatus);
            display.showStatus(reader.readCurrentStatus(resultStatus));
        }
        return resultStatus;
    }

    public void operateCarRace() {
        List<Car> cars;
        int repetition;

        display.showStartDisplay();
        cars = registerCars();
        display.showRepeatDisplay();
        repetition = scanRepetition();
        cars = repeatRace(cars, repetition);
        display.showWinners(reader.readHeadPositionNames(cars));
    }
}
