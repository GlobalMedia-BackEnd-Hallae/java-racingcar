package gmbs.model.game.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class GameRoundTest {

    private static final int DEFAULT_GAME_ROUND = 1;
    private static final int TOTAL_GAME_ROUND = 3;
    private static final GameRound STANDARD_GAME_ROUND = new GameRound(TOTAL_GAME_ROUND);

    @DisplayName("입력된 시도 총 시도 숫자가 1보다 작은 경우 에러를 발생시킨다")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void throwErrorWhenRoundInputIsUnderOne(int actual) {
        assertThatThrownBy(() -> new GameRound(actual))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 회수는 1보다 작을 수 없습니다");
    }

    @DisplayName("GameRound 생성 시 기본 게임 라운드가 1로 설정된다")
    @Test
    void createGameRound() {
        // then
        assertAll(
                () -> assertThat(STANDARD_GAME_ROUND.getTotalRoundForTest()).isEqualTo(TOTAL_GAME_ROUND),
                () -> assertThat(STANDARD_GAME_ROUND.getCurrentRoundForTest()).isEqualTo(DEFAULT_GAME_ROUND)
        );
    }

    @DisplayName("next 호출 시 게임 라운드를 1만큼 증가시킨다")
    @Test
    void nextIncreaseOneRound() {
        // given
        GameRound gameRound = STANDARD_GAME_ROUND;

        // when
        gameRound.next();

        // then
        assertThat(gameRound.getCurrentRoundForTest()).isEqualTo(DEFAULT_GAME_ROUND + 1);
    }

    @DisplayName("게임 라운드의 종료 여부를 확인한다")
    @ParameterizedTest
    @MethodSource("providerGameRoundAndExpect")
    void isNotOver(GameRound gameRound, boolean expect) {
        // when
        boolean actual = gameRound.isNotOver();

        System.out.println(gameRound.getCurrentRoundForTest());
        System.out.println(gameRound.getTotalRoundForTest());

        // then
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> providerGameRoundAndExpect() {
        return Stream.of(
                Arguments.of(STANDARD_GAME_ROUND, true),
                Arguments.of(getFinishGameRound(), false)
        );
    }

    private static GameRound getFinishGameRound() {
        final GameRound gameRound = new GameRound(TOTAL_GAME_ROUND);
        while (gameRound.getCurrentRoundForTest() <= TOTAL_GAME_ROUND) {
            gameRound.next();
        }
        return gameRound;
    }
}