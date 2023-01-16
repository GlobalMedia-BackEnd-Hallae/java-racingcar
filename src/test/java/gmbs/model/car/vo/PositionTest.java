package gmbs.model.car.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    private static final int STANDARD_POSITION = 5;
    private static final int LOWER_POSITION = 1;
    private static final int HIGHER_POSITION = 10;

    @DisplayName("인자 없이 기본 생성 시 기본 위치값 0 이 반환된다")
    @Test
    void createDefaultPosition() {
        // when
        Position position = new Position();

        // then
        assertThat(position.getValue()).isEqualTo(0);
    }

    @DisplayName("인자를 전달해 생성 시 기본 전달된 값이 위치값으로 반환된다")
    @Test
    void createParamPosition() {
        // when
        Position position = Position.fromTest(STANDARD_POSITION);

        // then
        assertThat(position.getValue()).isEqualTo(STANDARD_POSITION);
    }

    @DisplayName("increase 시 위치값이 1만큼 증가한다")
    @Test
    void increasePositionValue() {
        // given
        Position position = Position.fromTest(STANDARD_POSITION);

        // when
        position.increase();

        // then
        assertThat(position.getValue()).isEqualTo(STANDARD_POSITION + 1);
    }

    @DisplayName("다른 Position 보다 위치값이 크거나 같다면 true, 그렇지 않다면 false 를 반환한다")
    @ParameterizedTest
    @MethodSource("providerAnotherPosition")
    void isHigherThan(Position anotherPosition, boolean expect) {
        // given
        Position myPosition = Position.fromTest(STANDARD_POSITION);

        // when
        boolean isHigherThan = myPosition.isHigherThan(anotherPosition);

        // then
        assertThat(isHigherThan).isEqualTo(expect);
    }

    private static Stream<Arguments> providerAnotherPosition() {
        return Stream.of(
                Arguments.of(Position.fromTest(LOWER_POSITION), true),
                Arguments.of(Position.fromTest(STANDARD_POSITION), true),
                Arguments.of(Position.fromTest(HIGHER_POSITION), false)
        );
    }
}