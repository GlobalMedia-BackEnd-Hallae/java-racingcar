package Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumberCheckTest {

    NumberCheck numberCheck = new NumberCheck();

    @Test
    @DisplayName("음수, 0, 양수의 입력에 알맞게 대응하는지 테스트")
    void canNumberCheck() {
        // when
        int minus = -24;
        int zero = 0;
        int plus = 156;

        // given

        // then
        assertThatThrownBy(() -> numberCheck.numberCheck(minus))
                .isInstanceOf(IllegalStateException.class);

        assertThatThrownBy(() -> numberCheck.numberCheck(zero))
                .isInstanceOf(IllegalStateException.class);

        assertThat(numberCheck.numberCheck(plus)).isEqualTo(plus);
    }
}