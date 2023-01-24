package gmbs.controller;

import gmbs.model.RacingCars;
import gmbs.model.RandomNumberGenerator;
import gmbs.model.RepetitionNumber;
import gmbs.view.Display;
import gmbs.view.UserInput;

import java.util.Arrays;
import java.util.List;

public class CarRaceOperator {
    private static final String SPLIT_VALUE = ",";
    private static final Display display = new Display();

    private static final UserInput userInput = new UserInput();
    private static final RandomNumberGenerator generator = new RandomNumberGenerator(0, 9);

    private RacingCars racingCars;

    public void operate() {
        display.showStartDisplay();
        registerCars();
        display.showRepeatDisplay();
        repeatRace(scanRepetition());
        display.showWinners(racingCars.getHeadPositionNames());
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

    private List<String> splitInput(String userInput) {
        return Arrays.asList(userInput.split(SPLIT_VALUE));
    }

    private List<String> requestCarNames() {
        List<String> carNames;
        try {
            carNames = splitInput(userInput.userInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            carNames = requestCarNames();
        }
        return carNames;
    }

    private void registerCars() {
        try {
            racingCars = new RacingCars(requestCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            registerCars();
        }
    }

    private void repeatRace(RepetitionNumber reps) {
        for (int i = 0; i < reps.number(); i++) {
            racingCars.updateStatus(generator);
            display.showStatus(racingCars.getCurrentCarsStatus());
        }
    }
}
