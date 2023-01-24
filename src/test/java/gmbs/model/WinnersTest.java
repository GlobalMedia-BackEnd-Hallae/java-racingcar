package gmbs.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class WinnersTest {

    @Test
    void 공동_우승자() {
        // given
        String name1 = "kim";
        String name2 = "jun";

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(name1));
        cars.add(new Car(name2));

        // when
        Winners winners = new Winners(cars);

        // then
        assertThat(winners.getNames())
                .contains(name1, name2);
    }

    @Test
    void 우승자_1명() {
        // given
        String name1 = "kim";
        String name2 = "jun";

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(name1));

        Car car1 = new Car(name2);
        car1.move(6);
        cars.add(car1);

        // when
        Winners winners = new Winners(cars);

        // then
        assertThat(winners.getNames())
                .doesNotContain(name1);
    }

    @Test
    void maxPosition() {
        // given
        List<Car> cars = new ArrayList<>();
        Car car = new Car("kimjunseop");
        car.move(6);
        car.move(6);
        cars.add(car);

        // when
        Winners winners = new Winners(cars);

        // then
        assertThat(winners.getMaxPosition()).isEqualTo(2);
    }
}
