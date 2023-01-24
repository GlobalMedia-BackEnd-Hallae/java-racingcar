package gmbs.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {
    @Test
    void 랜덤_값() {
        // given
        int min = 0;
        int max = 10;

        // when
        int number = RandomGenerator.generateNumber(min, max);

        // then
        assertThat(number).isGreaterThanOrEqualTo(min).isLessThan(max);
    }

    @Test
    @DisplayName("max가_더_작은_경우")
    void less() {
        // given
        int min = 10;
        int max = 0;

        // when

        // then
        assertDoesNotThrow(() -> RandomGenerator.generateNumber(min, max));
    }
}
