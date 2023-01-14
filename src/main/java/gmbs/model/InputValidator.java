package gmbs.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final int LENGTH_THRESHOLD = 5;

    private boolean isNameOverflow(String input) {
        return input.length() > LENGTH_THRESHOLD;
    }

    public boolean isValidNames(List<String> inputNames) {
        Set<Boolean> nameOverflowChecker = new HashSet<>();
        for (String name : inputNames) {
            nameOverflowChecker.add(isNameOverflow(name));
        }
        return !nameOverflowChecker.contains(true) && !inputNames.isEmpty();
    }
}
