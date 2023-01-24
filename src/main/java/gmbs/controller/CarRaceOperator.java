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

    private RacingCars racingCars;

    public void operate() {
        display.showStartDisplay();
        registerCars();
        display.showRepeatDisplay();
        repeatRace(scanRepetition());
        display.showWinners(racingCars.getHeadPositionNames());
    }

    private void registerCars() {
        try {
            racingCars = new RacingCars(requestCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            registerCars();
        }
    }

    private List<String> requestCarNames() {
        List<String> carNames;
        carNames = splitInput(userInput.userInput());
        return carNames;
    }

    private List<String> splitInput(String userInput) {
        return Arrays.asList(userInput.split(SPLIT_VALUE));
    }

    private void repeatRace(RepetitionNumber reps) {
        for (int i = 0; i < reps.number(); i++) {
            racingCars.updateStatus(new RandomNumberGenerator());
            display.showStatus(racingCars.getCurrentCarsStatus());
        }
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
