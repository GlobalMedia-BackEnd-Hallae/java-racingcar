package gmbs.controller;

import gmbs.model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarStatusReaderTest {
    private static final CarStatusReader reader = new CarStatusReader();
    private static final CarManager manager = new CarManager();

    @ParameterizedTest
    @DisplayName("현재 car의 상태를 hashmap으로 반환한다")
    @MethodSource("generateCarStatus")
    public void currentStatus(List<Car> cars) {
        Map<String, Integer> carStatus = reader.readCurrentStatus(cars);
        for (Car car : cars) {
            //when
            int actual = carStatus.get(car.carName());
            int expected = car.carPosition();
            //then
            assertThat(actual).isEqualTo(expected);
        }
    }

    private static Stream<Arguments> generateCarStatus() {
        return Stream.of(
                Arguments.of(manager.createCar(Arrays.asList("name1", "name2", "name3"))),
                Arguments.of(manager.createCar(Arrays.asList("name1"))),
                Arguments.of(manager.createCar(Arrays.asList("1", "2", "3", "4", "5", "6")))
        );
    }

    @ParameterizedTest
    @DisplayName("position이 가장 큰 car의 name을 반환하는지 확인한다")
    @MethodSource("generateCarPositions")
    public void readHeadPositionNames(List<Car> cars, List<String> expected) {
        List<String> headPositionNames = new ArrayList<>(reader.readHeadPositionNames(cars));
        assertThat(headPositionNames).containsAll(expected);
    }

    private static Stream<Arguments> generateCarPositions() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Car("car1").move(1),
                                new Car("car2").move(2),
                                new Car("car3").move(2)),
                        Arrays.asList("car2", "car3")),
                Arguments.of(Arrays.asList(new Car("car1").move(1),
                                new Car("car2").move(2),
                                new Car("car3").move(2)),
                        Arrays.asList("car2", "car3"))
        );
    }
}