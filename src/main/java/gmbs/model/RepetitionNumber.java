package gmbs.model;

public class RepetitionNumber {

    private static final String NUMBER_REGEX = "^[0-9]*$";
    private final String repetition;

    public RepetitionNumber(String input) {
        repetition = input;
        validate();
    }

    private void validate() {
        if (!repetition.matches(NUMBER_REGEX) || repetition.equals("0") || repetition.length() == 0) {
            throw new IllegalArgumentException("[Error] 잘못된 반복횟수");
        }
    }

    public int number() {
        return Integer.parseInt(repetition);
    }
}
