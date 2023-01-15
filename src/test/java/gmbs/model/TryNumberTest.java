package gmbs.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryNumberTest {
    @Test
    void 정상_시도횟수() {
        // given
        TryNumber tryNumber = new TryNumber("1");

        // when
        // then
        assertThat(tryNumber).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaa", "-1"})
    void 생성_예외(String tryNumberString) {
        assertThatThrownBy(() -> new TryNumber(tryNumberString)).isInstanceOf(IllegalArgumentException.class);
    }
}
