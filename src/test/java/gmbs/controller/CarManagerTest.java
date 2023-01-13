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


class CarManagerTest {
    private static final CarManager carManager = new CarManager();

    @ParameterizedTest
    @DisplayName("주어진 이름의 car객체가 추가되었는지 확인한다")
    @MethodSource("generateCarNames")
    void createCar(List<String> carNames) {
        //when
        List<Car> cars = carManager.createCar(carNames);
        List<String> actual = new ArrayList<>();
        for (Car car : cars) {
            actual.add(car.carName());
        }
        //then
        assertThat(actual).isEqualTo(carNames);
    }

    static Stream<Arguments> generateCarNames() {
        return Stream.of(
                Arguments.of(Arrays.asList("name1", "name2", "name3")),
                Arguments.of(Arrays.asList("name1")),
                Arguments.of(Arrays.asList("1", "2", "3", "4", "5", "6"))
        );
    }

    @ParameterizedTest
    @DisplayName("주어진 리스트에서 car객체의 position만 0또는 1이 더해졌는지 확인한다")
    @MethodSource("generateCars")
    void updateStatus(List<Car> previousStatus) {
        List<Car> currentStatus = carManager.updateStatus(previousStatus);
        for (int i = 0; i < currentStatus.size(); i++) {
            //when
            Car currentCarStatus = currentStatus.get(i);
            Car previousCarStatus = previousStatus.get(i);
            int offset = currentCarStatus.carPosition() - previousCarStatus.carPosition();
            //then
            assertThat(offset).isIn(0, 1);
            assertThat(currentCarStatus.carName()).isEqualTo(previousCarStatus.carName());
        }

    }

    static Stream<Arguments> generateCars() {
        return Stream.of(
                Arguments.of(carManager.createCar(Arrays.asList("name1", "name2", "name3"))),
                Arguments.of(carManager.createCar(Arrays.asList("name1"))),
                Arguments.of(carManager.createCar(Arrays.asList("1", "2", "3", "4", "5", "6")))
        );
    }

    @ParameterizedTest
    @DisplayName("현재 car의 상태를 hashmap으로 반환한다")
    @MethodSource("generateCarStatus")
    void currentStatus(List<Car> cars) {
        Map<String, Integer> carStatus = carManager.currentStatus(cars);
        for (Car car : cars) {
            //when
            int actual = carStatus.get(car.carName());
            int expected = car.carPosition();
            //then
            assertThat(actual).isEqualTo(expected);
        }
    }

    static Stream<Arguments> generateCarStatus() {
        return Stream.of(
                Arguments.of(carManager.createCar(Arrays.asList("name1", "name2", "name3"))),
                Arguments.of(carManager.createCar(Arrays.asList("name1"))),
                Arguments.of(carManager.createCar(Arrays.asList("1", "2", "3", "4", "5", "6")))
        );
    }
}