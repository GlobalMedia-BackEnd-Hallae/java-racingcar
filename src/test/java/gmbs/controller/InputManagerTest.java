package gmbs.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputManagerTest {
    private static final InputManager input = new InputManager();

    @ParameterizedTest
    @DisplayName("1~5사이의 길이가 아니거나 공백을 포함한 문자열이 들어오면 예외를 발생시킨다")
    @ValueSource(strings = {"123456,123", "  ,12345", " 1 23,123", " 이런,456"})
    public void carNameInput_ExceptionByInvalidName(String invalidNames) {
        assertThatThrownBy(() -> input.carNameInput(invalidNames)).isInstanceOf(IllegalArgumentException.class).hasMessage("[Error] 이름은 1자 이상 5자 이하여야 한다.");
    }

    @ParameterizedTest
    @DisplayName("자연수가 아니면 예외를 발생시킨다")
    @ValueSource(strings = {"abc", "1ab", " ", "-1", "0"})
    public void repetitionInput(String invalidRepetition) {
        assertThatThrownBy(() -> input.repetitionInput(invalidRepetition)).isInstanceOf(IllegalArgumentException.class).hasMessage("[Error] 잘못된 반복횟수");
    }
}