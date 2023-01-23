package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("주어지는 조건에 따라 유동적으로 움직임 여부를 결정할 수 있다.")
    void canMove() {
        // given
        Position position = new Position();

        // when
        position.move(true);
        position.move(false);

        // then
        assertThat(position.getPosition()).isEqualTo(1);
    }

}