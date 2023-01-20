package gmbs.model.game.vo;

import java.util.Objects;

public class GameRound {

    private static final int DEFAULT_START_ROUND = 1;

    private final int totalRound;
    private int currentRound;

    public GameRound(final int totalRound) {
        checkRound(totalRound);
        this.totalRound = totalRound;
        this.currentRound = DEFAULT_START_ROUND;
    }

    private void checkRound(int totalRound) {
        if (totalRound <= DEFAULT_START_ROUND) {
            throw new IllegalArgumentException("[ERROR] 시도 회수는 1보다 작을 수 없습니다");
        }
    }

    public void next() {
        currentRound++;
    }

    public boolean isNotOver() {
        return currentRound <= totalRound;
    }

    public int getTotalRoundForTest() {
        return totalRound;
    }

    public int getCurrentRoundForTest() {
        return currentRound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameRound gameRound = (GameRound) o;
        return totalRound == gameRound.totalRound && currentRound == gameRound.currentRound;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalRound, currentRound);
    }
}
