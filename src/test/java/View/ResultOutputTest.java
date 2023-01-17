package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultOutputTest {

    // private ResultOutput resultOutput = new ResultOutput();

    @Test
    @DisplayName("우승자의 수와 상관없이 출력할 수 있다.")
    void canResultOutput() {
        // when
        List<String> OneWinner = new ArrayList<>();
        List<String> ManyWinners = new ArrayList<>();

        // given
        OneWinner.add("one");
        ManyWinners.add("one");
        ManyWinners.add("two");
        ManyWinners.add("three");

        // then

        // 테스트를 어떻게..?
    }
}