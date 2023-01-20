package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerCreateTest {
    private WinnerCreate winnerCreate = new WinnerCreate();

    @Test
    @DisplayName("개인 우승자 리스트를 알맞게 제작할 수 있다.")
    void canCreateOneWinner() {
        // given
        List<Car> carStatus = Arrays.asList(new Car("a"), new Car("b"), new Car("c"));
        carStatus.get(0).move(true);
        List<String> winner = new ArrayList<>();
        winner.add("a");

        // when
        List<String> result = winnerCreate.createWinner(carStatus);

        // then
        assertThat(result).isEqualTo(winner);
    }

    @Test
    @DisplayName("다수 우승자 리스트를 알맞게 제작할 수 있다.")
    void canCreateManyWinners() {
        // given
        List<Car> carStatus = Arrays.asList(new Car("a"), new Car("b"), new Car("c"));
        carStatus.get(0).move(true);
        carStatus.get(1).move(true);
        List<String> winners = Arrays.asList("a", "b");

        // when
        List<String> result = winnerCreate.createWinner(carStatus);

        // then
        assertThat(result).isEqualTo(winners);
    }
}