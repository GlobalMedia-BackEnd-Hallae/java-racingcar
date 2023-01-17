package model;

public class Position {

    private int pos;

    public Position() {
        this.pos = 0;
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
