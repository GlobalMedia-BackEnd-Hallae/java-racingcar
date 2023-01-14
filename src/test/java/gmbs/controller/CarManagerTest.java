package gmbs.controller;

import gmbs.model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
    @DisplayName("주어진 횟수만큼 car의 position에 0또는 1이 더해졌는지 확인한다")
    @MethodSource("generateCarStatus")
    void repeatUpdateStatus(List<Car> originStatus, int repeat) {
        List<Car> updateStatus = carManager.repeatUpdateStatus(originStatus, repeat);
        List<Integer> possibleDisplacement = new ArrayList<>(IntStream.rangeClosed(0, repeat).boxed().collect(Collectors.toList()));
        for (int i = 0; i < originStatus.size(); i++) {
            //when
            Car updateCarStatus = updateStatus.get(i);
            Car originCarStatus = originStatus.get(i);
            int actualDisplacement = updateCarStatus.carPosition() - originCarStatus.carPosition();
            //then
            assertThat(actualDisplacement).isIn(possibleDisplacement);
            assertThat(updateCarStatus.carName()).isEqualTo(originCarStatus.carName());
        }
    }

    static Stream<Arguments> generateCarStatus() {
        return Stream.of(
                Arguments.of(carManager.createCar(Arrays.asList("name1", "name2", "name3")), 3),
                Arguments.of(carManager.createCar(Arrays.asList("name1", "name2", "name3")), 1)
        );
    }
}
