package gmbs.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "1"})
    @DisplayName("생성 성공")
    public void success(String string) {
        // given
        TryNumber tryNumber = new TryNumber(string);

        // when
        // then
        assertThat(tryNumber).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaa", "-1", "1001"})
    @DisplayName("생성 실패")
    public void failed(String tryCountString) {
        assertThatThrownBy(() -> new TryNumber(tryCountString)).isInstanceOf(IllegalArgumentException.class);
    }
}
