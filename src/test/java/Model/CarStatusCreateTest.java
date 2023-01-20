package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarStatusCreateTest {

    private CarStatusCreate carStatusCreate = new CarStatusCreate();

    @Test
    @DisplayName("조건에 어긋나는 문자열을 입력해서 오류가 나는지 테스트")
    void canCarCheckError() {
        // given
        List<String> wrongInput = Arrays.asList("abcde", "abcdef", "abcd");

        // when, then
        assertThatThrownBy(() -> carStatusCreate.createCarStatus(wrongInput))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("조건에 맞는 문자열 입력해서 잘 돌아가는지 테스트")
    void canCarCreateRightStatus() {
        // given
        List<String> rightInput = Arrays.asList("pobi", "woni", "jun");

        // when
        List<Car> result = carStatusCreate.createCarStatus(rightInput);

        // then
        assertThat(result.get(0).carName()).isEqualTo(rightInput.get(0));
        assertThat(result.get(1).carName()).isEqualTo(rightInput.get(1));
        assertThat(result.get(2).carName()).isEqualTo(rightInput.get(2));

        assertThat(result.get(0).carPosition()).isZero();
        assertThat(result.get(1).carPosition()).isZero();
        assertThat(result.get(2).carPosition()).isZero();
    }
}