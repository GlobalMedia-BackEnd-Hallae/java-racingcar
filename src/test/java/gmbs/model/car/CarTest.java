package gmbs.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static final Car STANDARD_CAR = Car.ofTest("myCar", 5);
    private static final Car LOWER_POSITION_THAN_STANDARD = Car.ofTest("test1", 1);
    private static final Car HIGHER_POSITION_THAN_STANDARD = Car.ofTest("test2", 10);
    private static final Car SAME_POSITION_WITH_STANDARD = Car.ofTest("test3", 5);

    @DisplayName("자동차의 이름값을 가져온다")
    @Test
    void getNameValue() {
        // when
        String actual = STANDARD_CAR.getNameValue();

        // then
        assertThat(actual).isEqualTo("myCar");
    }

    @DisplayName("자동차의 위치값을 가져온다")
    @Test
    void getPositionValue() {
        // when
        int actual = STANDARD_CAR.getPositionValue();

        // then
        assertThat(actual).isEqualTo(5);
    }

    @DisplayName("movable 이 true 이면 1만큼 전진하고, false 라면 전진하지 않는다")
    @ParameterizedTest
    @MethodSource("providerCarAndMovableAndExpectPositionValue")
    void moveForward(Car car, boolean movable, int expect) {
        // when
        car.moveForward(movable);

        // then
        assertThat(car.getPositionValue()).isEqualTo(expect);
    }

    private static Stream<Arguments> providerCarAndMovableAndExpectPositionValue() {
        return Stream.of(
                Arguments.of(new Car("벤틀리"), true, 1),
                Arguments.of(new Car("람보르기니"), false, 0)
        );
    }

    @DisplayName("모든 자동차 리스트를 받아, 해당 자동차의 위치가 가장 먼 경우 true 를, 그렇지 않으면 false 를 반환한다")
    @ParameterizedTest
    @MethodSource("providerAllCarAndExpect")
    void isFarthest(List<Car> allCars, boolean expect) {
        // when
        boolean isFarthest = STANDARD_CAR.isFarthest(allCars);

        // then
        assertThat(isFarthest).isEqualTo(expect);
    }

    private static Stream<Arguments> providerAllCarAndExpect() {
        return Stream.of(
                Arguments.of(List.of(STANDARD_CAR, LOWER_POSITION_THAN_STANDARD, HIGHER_POSITION_THAN_STANDARD), false),
                Arguments.of(List.of(STANDARD_CAR, LOWER_POSITION_THAN_STANDARD, LOWER_POSITION_THAN_STANDARD), true),
                Arguments.of(List.of(STANDARD_CAR, HIGHER_POSITION_THAN_STANDARD, HIGHER_POSITION_THAN_STANDARD), false),
                Arguments.of(List.of(STANDARD_CAR, SAME_POSITION_WITH_STANDARD, SAME_POSITION_WITH_STANDARD), true)
        );
    }
}