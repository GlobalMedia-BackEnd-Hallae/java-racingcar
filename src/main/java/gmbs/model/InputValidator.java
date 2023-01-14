package gmbs.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final int LENGTH_THRESHOLD = 5;

    private boolean isNameOverflow(String input) {
        return input.length() > LENGTH_THRESHOLD;
    }

    private boolean hasBlank(String input) {
        return !input.replace(" ", "").equals(input);
    }

    public boolean isValidNames(List<String> inputNames) {
        Set<Boolean> invalidNameChecker = new HashSet<>();
        for (String name : inputNames) {
            invalidNameChecker.add(isNameOverflow(name));
            invalidNameChecker.add(hasBlank(name));
        }
        return !invalidNameChecker.contains(true) && !inputNames.isEmpty();
    }

    public boolean isNaturalNumber(String userRepetitionInput) {
        return userRepetitionInput.matches("^[1-9]*$");
    }
}
