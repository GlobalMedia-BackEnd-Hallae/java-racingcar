package model;

public class NumberCheck {

    public int numberCheck(int number) {
        final int NUMBER_LIMIT = 1;

        if (number < NUMBER_LIMIT) {
            throw new IllegalStateException();
        }

        return number;
    }
}
