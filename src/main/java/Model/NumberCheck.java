package Model;

public class NumberCheck {

    private static final int NUMBER_LIMIT = 1;

    public int numberCheck(int number) {
        if (number < NUMBER_LIMIT) {
            throw new IllegalStateException();
        }

        return number;
    }
}
