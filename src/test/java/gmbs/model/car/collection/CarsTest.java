package gmbs.model.car.collection;

import gmbs.model.car.Car;
import gmbs.model.car.vo.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private static final int INDEX_INIT = 0;
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;

    private final String[] carNames = new String[] {"페라리", "람보르기니" ,"포드"};
    private Cars cars;
    private final boolean[] movable = new boolean[] {true, true, false};
    private int index = 0;

    @BeforeEach
    void setup_given() {
        cars = new Cars(carNames);
    }

    @DisplayName("주어진 Cars 를 가져온다")
    @Test
    void getCars() {
        // when
        List<Car> actual = cars.getCars();

        // then
        assertAll(
                () -> assertThat(actual).hasSize(3),
                () -> assertThat(actual.get(FIRST).getNameValue()).isEqualTo(carNames[FIRST]),
                () -> assertThat(actual.get(SECOND).getNameValue()).isEqualTo(carNames[SECOND]),
                () -> assertThat(actual.get(THIRD).getNameValue()).isEqualTo(carNames[THIRD]),
                () -> {
                    for (Car car : actual) {
                        int defaultPositionValue = new Position().getValue();
                        assertThat(car.getPositionValue()).isEqualTo(defaultPositionValue);
                    }
                }
        );
    }

    @DisplayName("이동 조건에 부합하면 자동차를 이동시킨다")
    @Test
    void race() {
        // when
        cars.race(() -> movable[index++]);

        // then
        List<Car> movedCars = cars.getCars();
        assertAll(
                () -> assertThat(movedCars.get(FIRST).getPositionValue()).isEqualTo(1),
                () -> assertThat(movedCars.get(SECOND).getPositionValue()).isEqualTo(1),
                () -> assertThat(movedCars.get(THIRD).getPositionValue()).isEqualTo(0)
        );
    }

    @DisplayName("위치가 가장 멀리에 있는 자동차의 이름이 반환된다")
    @Test
    void getWinnerCarName() {
        // given
        index = INDEX_INIT;
        cars.race(() -> movable[index++]);

        // when
        List<String> winnerCarName = cars.getWinnerCarName();

        // then
        assertAll(
                () -> assertThat(winnerCarName).hasSize(2),
                () -> assertThat(winnerCarName.get(FIRST)).isEqualTo("페라리"),
                () -> assertThat(winnerCarName.get(SECOND)).isEqualTo("람보르기니")
        );
    }
}