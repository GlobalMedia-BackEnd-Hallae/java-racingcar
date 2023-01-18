package gmbs.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    private static Stream<Arguments> generateCarNames() {
        return Stream.of(
                Arguments.of(Arrays.asList("name1", "name2", "name3")),
                Arguments.of(Arrays.asList("name1")),
                Arguments.of(Arrays.asList("1", "2", "3", "4", "5", "6"))
        );
    }

    @ParameterizedTest
    @DisplayName("update된 car의 position이 0또는 1의 차이가 나는지 확인한다")
    @MethodSource("generateCarStatus")
    void UpdateStatus(List<Car> originStatus) {
        List<Car> updateStatus = carManager.updateStatus(originStatus);
        List<Integer> possibleDisplacement = new ArrayList<>(Arrays.asList(0, 1));
        for (int i = 0; i < originStatus.size(); i++) {
            //when
            Car updateCar = updateStatus.get(i);
            Car originCar = originStatus.get(i);
            int actualDisplacement = updateCar.carPosition() - originCar.carPosition();
            //then
            assertThat(actualDisplacement).isIn(possibleDisplacement);
            assertThat(updateCar.carName()).isEqualTo(originCar.carName());
        }
    }

    private static Stream<Arguments> generateCarStatus() {
        return Stream.of(
                Arguments.of(carManager.createCar(Arrays.asList("name1", "name2", "name3"))),
                Arguments.of(carManager.createCar(Arrays.asList("name1", "name2", "name3", "name4")))
        );
    }
}
