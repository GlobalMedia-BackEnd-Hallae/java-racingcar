package gmbs.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingCarsTest {

    private final List<String> names = Arrays.asList("레드불", "페라리", "메르세데스");
    private final int[] generatedNumbers = {5, 6, 4};
    private final RacingCars cars = new RacingCars(names);
    private int index = 0;

    @Test
    @DisplayName("car position이 가장 큰 차의 이름을 반환한다")
    void getHeadPositionNames() {
        cars.updateStatus(() -> generatedNumbers[index++]);
        List<String> expectedNames = Arrays.asList("레드불", "페라리");
        assertThat(cars.getHeadPositionNames()).isEqualTo(expectedNames);
    }
}
