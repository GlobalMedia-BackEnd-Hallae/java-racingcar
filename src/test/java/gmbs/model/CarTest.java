package gmbs.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    private static final int THRESHOLD = 4;
    private static final int TRAVEL_DISTANCE_UNIT = 1;
    private static final int DO_NOTHING_UNIT = 0;

    @ParameterizedTest
    @DisplayName("기준 이상의 수를 넣으면 carposition에 기준 거리가 더해진다")
    @MethodSource("carPositionCheckData")
    void moveByCondition(int input, int expectedPositionDifference) {
        Car testCar = new Car("test");
        int originPosition = testCar.carPosition();
        testCar.moveByCondition(input);
        int updatePosition = testCar.carPosition();
        int actualPositionDifference = updatePosition - originPosition;

        assertThat(actualPositionDifference).isEqualTo(expectedPositionDifference);
    }

    static Stream<Arguments> carPositionCheckData() {
        return Stream.of(
                Arguments.of(THRESHOLD, TRAVEL_DISTANCE_UNIT),
                Arguments.of(THRESHOLD - 1, DO_NOTHING_UNIT)
        );
    }
}