package gmbs.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    @ParameterizedTest
    @DisplayName("4 이상의 수를 넣으면 carposition에 1이 더해진다")
    @CsvSource(value = {"4, 0", "5, 1"})
    void moveByCondition(int input, int expectedPositionDifference) {
        Car origin = new Car("test");
        Car update = origin.moveByCondition(input);
        int actualPositionDifference = update.carPosition() - origin.carPosition();

        assertThat(actualPositionDifference).isEqualTo(expectedPositionDifference);
    }
}