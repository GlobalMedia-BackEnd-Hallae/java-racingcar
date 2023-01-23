package gmbs.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 생성_성공() {
        // given
        String names = "kim,jun,seop";

        // when
        // then
        assertThatCode(() -> {
            new Cars(names);
        }).doesNotThrowAnyException();
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
