package gmbs.controller;

import gmbs.view.Display;
import gmbs.view.UserInput;

import java.util.ArrayList;
import java.util.List;

public class CarRaceOperator {
    private static final Display display = new Display();
    private static final UserInput userInput = new UserInput();
    private static final InputManager inputManager = new InputManager();
    private static final RaceManager raceManager = new RaceManager();

    private List<String> scanCarNames() {
        List<String> carNames = new ArrayList<>();
        while (true) {
            try {
                carNames = inputManager.carNameInput(userInput.userInput());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return carNames;
    }

    private int scanRepetition() {
        int repetition;
        while (true) {
            try {
                repetition = inputManager.repetitionInput(userInput.userInput());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return repetition;
    }

    public void operateCarRace() {
        List<String> carNames;
        int repetition;

        display.showStartDisplay();
        carNames = scanCarNames();
        display.showRepeatDisplay();
        repetition = scanRepetition();
        raceManager.startRace(carNames, repetition);
    }
}
