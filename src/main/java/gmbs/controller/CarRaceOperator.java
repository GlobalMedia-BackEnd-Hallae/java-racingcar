package gmbs.controller;

import gmbs.model.CarName;
import gmbs.model.RacingCars;
import gmbs.model.RandomNumberGenerator;
import gmbs.model.RepetitionNumber;
import gmbs.view.Display;
import gmbs.view.UserInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRaceOperator {

    private static final Display display = new Display();
    private static final UserInput userInput = new UserInput();

    public void operate() {
        display.showStartDisplay();
        RacingCars cars = registerCars(requestCarNames());
        display.showRepeatDisplay();
        repeatRace(cars, scanRepetition());
        display.showWinners(cars.getHeadPositionNames());
    }

    private RacingCars registerCars(List<CarName> carNames) {
        return new RacingCars(carNames);
    }

    private List<CarName> requestCarNames() {
        List<CarName> carNames = new ArrayList<>();
        try {
            splitInput(userInput.userInput(), ",").forEach(name -> carNames.add(new CarName(name)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestCarNames();
        }
        return carNames;
    }

    private List<String> splitInput(String userInput, String regex) {
        return Arrays.asList(userInput.split(regex));
    }

    private RacingCars repeatRace(RacingCars cars, RepetitionNumber reps) {
        for (int i = 0; i < reps.number(); i++) {
            cars.updateStatus(new RandomNumberGenerator());
            display.showStatus(cars.getCurrentCarsStatus());
        }
        return cars;
    }

    private RepetitionNumber scanRepetition() {
        RepetitionNumber reps;
        try {
            reps = new RepetitionNumber(userInput.userInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            reps = scanRepetition();
        }
        return reps;
    }
}
