package gmbs.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    private static final Race race = new Race();

    @Test
    @DisplayName("name은 같고 position은 다를 수도 있는 car 객체를 반환한다")
    void updatePosition() {
        Car car = new Car("car1");
        Car newCar = race.updatePosition(car);
        assertThat(newCar.carName()).isEqualTo(car.carName());
    }
}
