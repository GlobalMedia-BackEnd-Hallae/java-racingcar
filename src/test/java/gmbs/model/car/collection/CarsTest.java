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
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private static final int THIRD_INDEX = 2;
    private static final String[] CAR_NAMES = new String[] {"페라리", "람보르기니" ,"포드"};
    private static final boolean[] MOVABLE = new boolean[] {true, true, false};

    private Cars cars;
    private int index = 0;

    @BeforeEach
    void setUp() {
        cars = new Cars(CAR_NAMES);
    }

    @DisplayName("주어진 Cars 를 가져온다")
    @Test
    void getCars() {
        // when
        List<Car> actual = cars.getCars();

        // then
        assertAll(
                () -> assertThat(actual).hasSize(3),
                () -> assertThat(actual.get(FIRST_INDEX).getNameValue()).isEqualTo(CAR_NAMES[FIRST_INDEX]),
                () -> assertThat(actual.get(SECOND_INDEX).getNameValue()).isEqualTo(CAR_NAMES[SECOND_INDEX]),
                () -> assertThat(actual.get(THIRD_INDEX).getNameValue()).isEqualTo(CAR_NAMES[THIRD_INDEX]),
                () -> {
                    int defaultPositionValue = new Position().getValue();
                    for (Car car : actual) {
                        assertThat(car.getPositionValue()).isEqualTo(defaultPositionValue);
                    }
                }
        );
    }

    @DisplayName("movable 이 true 이면 자동차를 이동시키고 false 이면 움직이지 않는다")
    @Test
    void race() {
        // when
        cars.race(() -> MOVABLE[index++]);

        // then
        List<Car> movedCars = cars.getCars();
        assertAll(
                () -> assertThat(movedCars.get(FIRST_INDEX).getPositionValue()).isEqualTo(1),
                () -> assertThat(movedCars.get(SECOND_INDEX).getPositionValue()).isEqualTo(1),
                () -> assertThat(movedCars.get(THIRD_INDEX).getPositionValue()).isZero()
        );
    }

    @DisplayName("위치가 가장 멀리에 있는 자동차의 이름이 반환된다")
    @Test
    void getWinnerCarName() {
        // given
        index = INDEX_INIT;
        cars.race(() -> MOVABLE[index++]);

        // when
        List<String> winnerCarNames = cars.getWinnerCarName();

        // then
        assertAll(
                () -> assertThat(winnerCarNames).hasSize(2),
                () -> assertThat(winnerCarNames.get(FIRST_INDEX)).isEqualTo("페라리"),
                () -> assertThat(winnerCarNames.get(SECOND_INDEX)).isEqualTo("람보르기니")
        );
    }
}