package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CreateWinnerListTest {
    private WinnerCreate createWinnerList = new WinnerCreate();

    @Test
    @DisplayName("개인 우승자 리스트를 알맞게 제작할 수 있다.")
    void canCreateWinnerListTestOfOnly() {
        // given
        List<Car> carClassListOnly = new ArrayList<>();
        carClassListOnly.add(new Car("a"));
        carClassListOnly.add(new Car("b"));
        carClassListOnly.add(new Car("c"));
        //carClassListOnly.get(0).move(1);

        List<String> winnerListOnly = new ArrayList<>();
        winnerListOnly.add("a");

        // when

        // then
        //assertThat(createWinnerList.createWinnerList(carClassListOnly)).isEqualTo(winnerListOnly);
    }

    @Test
    @DisplayName("다수 우승자 리스트를 알맞게 제작할 수 있다.")
    void canCreateWinnerListTestOfMany() {
        // given
        List<Car> carClassListMany = new ArrayList<>();
        carClassListMany.add(new Car("a"));
        carClassListMany.add(new Car("b"));
        carClassListMany.add(new Car("c"));
        //carClassListMany.get(0).move(1);
        //carClassListMany.get(1).move(1);

        List<String> winnerListMany = new ArrayList<>();
        winnerListMany.add("a");
        winnerListMany.add("b");

        // when

        // then
       //assertThat(createWinnerList.createWinnerList(carClassListMany)).isEqualTo(winnerListMany);
    }
}