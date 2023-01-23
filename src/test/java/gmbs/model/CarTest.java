package gmbs.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {
    @Test
    void 자동차_생성() {
        // given
        String name = "test1";

        // when
        // then
        assertThatCode(() -> {
            new Cars(name);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({"4, 1", "3, 0"})
    void 전진_정지(int random, int expected) {
        // given
        Car car = new Car("test");

        // when
        car.move(random);

        // then
        assertThat(car.getPosition()).isEqualTo(expected);
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
