package gmbs.controller;

import gmbs.model.RacingCars;
import gmbs.model.RepetitionNumber;
import gmbs.view.Display;
import gmbs.view.UserInput;

import java.util.Arrays;
import java.util.List;

public class CarRaceOperator {

    private static final Display display = new Display();
    private static final UserInput userInput = new UserInput();
    private static final String SPLIT_VALUE = ",";

    private RacingCars racingCars;

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

    private void repeatRace(int repetition) {
        for (int i = 0; i < repetition; i++) {
            racingCars.updateStatus();
            display.showStatus(racingCars.getCurrentCarsStatus());
        }
    }

    public void operate() {
        display.showStartDisplay();
        registerCars();
        display.showRepeatDisplay();
        repeatRace(scanRepetition());
        display.showWinners(racingCars.getHeadPositionNames());
    }
}
