package gmbs.controller;

import gmbs.model.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputManager {

    private static final String SPLIT_VALUE = ",";
    private static final InputValidator validator = new InputValidator();

    private void nameOverflowException() throws IllegalArgumentException {
        throw new IllegalArgumentException("[Error] 이름은 1자 이상 5자 이하여야 한다.");
    }

    private void illegalRepetitionInputException() throws IllegalArgumentException {
        throw new IllegalArgumentException("[Error] 잘못된 반복횟수");
    }

    public List<String> carNameInput(String userInput) {
        List<String> carNames = new ArrayList<>(Arrays.asList(userInput.split(SPLIT_VALUE)));
        if (!validator.isValidNames(carNames)) {
            nameOverflowException();
        }
        return carNames;
    }

    public int repetitionInput(String userInput) {
        if (!validator.isNaturalNumber(userInput)) {
            illegalRepetitionInputException();
        }
        return Integer.parseInt(userInput);
    }
}
