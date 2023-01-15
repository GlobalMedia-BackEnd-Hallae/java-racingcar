package gmbs.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @Test
    void 자동차_생성() {
        // given
        String name = "test1";

        // when
        Car car = new Car(name);

        // then
        assertThat(car).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456", " "})
    void 자동차_생성_실패(String name) {
        // then
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 전진() {
        move_테스트(6, 1);
    }

    @Test
    void 정지() {
        move_테스트(3, 0);
    }

    void move_테스트(int random, int expected) {
        // given
        Car car = new Car("test");

        // when
        car.move(random);

        // then
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @Test
    void toString_체크() {
        // given
        Car car = new Car("test");

        // when
        car.move(6);

        // then
        assertThat(car.toString()).isEqualTo("test : -");
    }
}
