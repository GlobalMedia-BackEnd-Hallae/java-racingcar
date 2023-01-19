package gmbs.model.car.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class NameTest {

    private static final String OVER_THAN_MAX_LENGTH = "SixLen";
    private static final String BLANK = " ";

    @DisplayName("이름의 길이가 5자 이하면 그 이름을 갖는 Name 객체가 생성된다")
    @ParameterizedTest
    @CsvSource({"벤틀리, 벤틀리", "람보르기니, 람보르기니"})
    void createName(String carName, String expect) {
        // when
        Name name = new Name(carName);

        // then
        assertThat(name.getValue()).isEqualTo(expect);
    }

    @DisplayName("5자가 넘는 자동차 이름이 들어오면 예외를 발생시킨다")
    @Test
    void throwErrorWhenValueLengthIsLongerThanMaxLength() {
        // when, then
        assertThatThrownBy(() -> new Name(OVER_THAN_MAX_LENGTH))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자를 넘길 수 없습니다");
    }

    @DisplayName("자동차 이름이 공백이면 예외를 발생시킨다")
    @Test
    void throwErrorWhenValueIsBlank() {
        // when, then
        assertThatThrownBy(() -> new Name(BLANK))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 공백일 수 없습니다. 다시 입력하세요");
    }
}