package gmbs.model;

public class RepetitionNumber {
    private static final String REGEX_FOR_NUMBER = "^[0-9]*$";
    private final String repetition;

    public RepetitionNumber(String input) {
        repetition = input;
        validate();
    }

    private void validate() {
        if (repetition.matches(REGEX_FOR_NUMBER) || repetition.equals("0")) {
            throw new IllegalArgumentException("[Error] 잘못된 반복횟수");
        }
    }

    public String number() {
        return repetition;
    }
}
