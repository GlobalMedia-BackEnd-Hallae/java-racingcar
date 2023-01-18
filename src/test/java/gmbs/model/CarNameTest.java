package gmbs.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarNameTest {

    @ParameterizedTest
    @DisplayName("이름이 1~5자가 아니면 예외가 발생하는지 확인한다")
    @ValueSource(strings = {"", "123456"})
    void CarName_ExceptionByNameOverflow(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[Error] 이름은 1자 이상 5자 이하여야 한다.");
    }

    @ParameterizedTest
    @DisplayName("이름에 공백이 있으면 예외가 발생하는지 확인한다")
    @ValueSource(strings = {" ", "1 6"})
    void CarName_ExceptionByBlank(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[Error] 공백 금지");
    }
}