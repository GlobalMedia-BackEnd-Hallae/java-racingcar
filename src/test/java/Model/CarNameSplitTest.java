package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarNameSplitTest {

    @Test
    @DisplayName("차이름을 쉼표를 기준으로 알맞게 잘라 배열을 반환할 수 있다.")
    void canSplitCarName() {
        // given
        CarNameSplit carNameSplit = new CarNameSplit();
        String carName = "pobi,woni,jun";
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");

        // when
        List<String> result = carNameSplit.splitCarName(carName);

        // then
        assertThat(result).isEqualTo(carNames);
    }
}