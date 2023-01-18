package gmbs.controller;

import java.util.Arrays;
import java.util.List;

public class InputConverter {

    public List<String> splitInputBy(String userInput, String splitBy) {
        return Arrays.asList(userInput.split(splitBy));
    }
}
