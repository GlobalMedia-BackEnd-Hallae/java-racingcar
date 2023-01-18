package gmbs.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RepetitionNumberTest {


    @ParameterizedTest
    @DisplayName("자연수가 아니면 예외를 발생시킨다")
    @ValueSource(strings = {"abc", "1ab", " ", "-1", "0"})
    void RepetitionNumber_ExceptionThrownByInvalidInput(String invalidInput) {
        assertThatThrownBy(() -> new RepetitionNumber(invalidInput)).isInstanceOf(IllegalArgumentException.class).hasMessage("[Error] 잘못된 반복횟수");
    }
}