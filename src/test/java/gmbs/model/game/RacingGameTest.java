package gmbs.model.game;

import gmbs.model.car.Car;
import gmbs.model.condition.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private static final int THIRD_INDEX = 2;
    private static final String[] CAR_NAMES = new String[] {"페라리", "람보르기니" ,"포드"};
    private static final boolean[] MOVABLE = new boolean[] {true, true, false};

    private int index;
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        index = 0;
        final Condition moveCondition = () -> MOVABLE[index++];
        racingGame = new RacingGame(CAR_NAMES, moveCondition);
    }

    @DisplayName("게임 라운드 진행 시 movable 에 따라 자동차가 전진한다")
    @Test
    void playRound() {
        // when
        List<Car> actual = racingGame.playRound();

        // then
        assertAll(
                () -> assertThat(actual.get(FIRST_INDEX).getPositionValue()).isEqualTo(1),
                () -> assertThat(actual.get(SECOND_INDEX).getPositionValue()).isEqualTo(1),
                () -> assertThat(actual.get(THIRD_INDEX).getPositionValue()).isZero()
        );
    }

    @DisplayName("게임 라운드 종료 시 우승한 자동차의 이름을 반환한다")
    @Test
    void finish() {
        // given
        racingGame.playRound();

        // when
        List<String> actual = racingGame.finish();

        // then
        assertAll(
                () -> assertThat(actual.get(FIRST_INDEX)).isEqualTo("페라리"),
                () -> assertThat(actual.get(SECOND_INDEX)).isEqualTo("람보르기니")
        );
    }
}