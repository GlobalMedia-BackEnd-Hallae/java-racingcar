package model;

public class Position {

    private int pos;

    public Position() {
        final int INITIAL_VALUE = 0;

        this.pos = INITIAL_VALUE;
    }

    public void move(boolean advance) {
        if (advance) {
            this.pos++;
        }
    }

    public int getPosition() {
        return pos;
    }
}
