package gmbs.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void 생성_성공() {
        // given
        String names = "kim,jun,sep";

        // when
        Cars cars = new Cars(names);

        // then
        assertThat(cars).isNotNull();
    }

    @Test
    void 중복_체크() {
        // given
        String names = "kim,kim,jun";

        // when
        // then
        assertThatThrownBy(() -> new Cars(names)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void toString_결과_생성() {
        // given
        String names = "jun,sep";
        Cars cars = new Cars(names);
        String newLine = System.lineSeparator();

        // when
        // then
        assertThat(cars.toString()).isEqualTo("jun : " + newLine + "sep : " + newLine);
    }
}
