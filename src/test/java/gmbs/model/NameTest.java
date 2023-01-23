package gmbs.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    private static final String EMPTY_NAME_MESSAGE = "[ERROR] 이름은 빈 값으로 입력할 수 없습니다.";
    private static final String LONG_NAME_MESSAGE = "[ERROR] 5글자를 초과하는 이름이 존재합니다.";
    private static final String DUPLICATED_NAME_MESSAGE = "[ERROR] 중복된 이름이 있습니다";

    @Test
    @DisplayName("Name 정상 생성")
    void success() {
        // when
        Name name = new Name("test");

        // then
        assertThat(name).isNotNull();
    }


    @ParameterizedTest
    @ValueSource(strings = {"", " ", "1231456"})
    @DisplayName("Name 생성 실패")
    void failed(String string) {
        // then
        assertThatThrownBy(() -> new Name(string)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 중복될 경우 에러를 발생시킨다.")
    void testOverrapingNames() {
        // given
        String names = "kim,kim,jun";

        // when
        // then
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_NAME_MESSAGE);
    }

    @DisplayName("5자가 넘는 자동차 이름이 들어오면 예외를 발생시킨다")
    @Test
    void testOverLengthName() {
        // when, then
        assertThatThrownBy(() -> new Name("kimjunseop"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LONG_NAME_MESSAGE);
    }

    @Test
    @DisplayName("빈 문자열을 입력했을 경우 에러를 발생시킨다.")
    void testBlankInput() {
        // when, then
        assertThatThrownBy(() -> new Name(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_NAME_MESSAGE);
    }
}