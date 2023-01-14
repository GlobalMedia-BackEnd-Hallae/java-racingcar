package Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarCheckTest {

    private CarCheck carCheck = new CarCheck();

    @Test
    @DisplayName("조건에 어긋나는 이름을 입력해서 오류가 나는지 테스트")
    void canCarCheckError() {
        // given
        String wrongInput = "abcde,abcdef,abcd,a,b";

        // when

        // then
        assertThatThrownBy(() -> carCheck.carCheck(wrongInput))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("조건에 맞는 문자열 입력해서 잘 돌아가는지 테스트")
    void canCarCheckRight() {
        // given
        String rightInput = "pobi,woni,jun";

        // when
        List<String> rightInputList = new ArrayList<>();
        rightInputList.add("pobi");
        rightInputList.add("woni");
        rightInputList.add("jun");

        // then
        assertThat(carCheck.carCheck(rightInput)).isEqualTo(rightInputList);
    }
}