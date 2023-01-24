package gmbs.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    private static final String DUPLICATED_NAME_MESSAGE = "[ERROR] 중복된 이름이 있습니다";

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
    void 중복_체크() {
        // given
        String names = "jun,jun";

        // when
        // then
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_NAME_MESSAGE);

    }
}
