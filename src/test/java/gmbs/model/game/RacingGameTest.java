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

    private final String[] carNames = new String[] {"페라리", "람보르기니" ,"포드"};
    private final boolean[] movable = new boolean[] {true, true, false};
    private int index;
    private RacingGame racingGame;

    @BeforeEach
    void setup() {
        index = 0;
        final Condition moveCondition = () -> movable[index++];
        racingGame = new RacingGame(carNames, moveCondition);
    }

    @DisplayName("게임 라운드 진행 시 자동차가 전진한다")
    @Test
    void playRound() {
        // when
        List<Car> actual = racingGame.playRound();

        // then
        assertAll(
                () -> assertThat(actual.get(0).getPositionValue()).isEqualTo(1),
                () -> assertThat(actual.get(1).getPositionValue()).isEqualTo(1),
                () -> assertThat(actual.get(2).getPositionValue()).isEqualTo(0)
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
                () -> assertThat(actual.get(0)).isEqualTo("페라리"),
                () -> assertThat(actual.get(1)).isEqualTo("람보르기니")
        );
    }
}