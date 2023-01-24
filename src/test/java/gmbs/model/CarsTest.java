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
}
