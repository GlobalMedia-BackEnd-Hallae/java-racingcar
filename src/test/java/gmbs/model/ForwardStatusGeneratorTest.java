package gmbs.model;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ForwardStatusGeneratorTest {

    private static final ForwardStatusGenerator statusGenerator = new ForwardStatusGenerator();

    @ParameterizedTest
    @DisplayName("주어진 수 사이의 무작위 정수를 반환한다")
    @CsvSource(value = {"0,9", "1,9"})
    public void randomCarStatus(int rangeStart,int rangeEnd) {
        HashSet<Integer> actual = new HashSet<>();
        HashSet<Integer> expected = new HashSet<>();
        int testCase = 1000;
        for(int i=rangeStart; i<=rangeEnd; i++) {
            expected.add(i);
        }
        for(int i = 0; i< testCase; i ++) {
            actual.add(statusGenerator.randomNumber(rangeStart,rangeEnd));
        }
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("기준 이상의 수가 생성되면 true를 반환한다")
    @CsvSource(value = {"0,9,4", "1,5,3"})
    public void isMoveForward(int rangeStart, int rangeEnd, int referenceCondition) {
        float trueCount = 0;
        float testCase = 10000;

        for (int i = 0; i < testCase; i++) {
            if(statusGenerator.isMoveForward(rangeStart, rangeEnd, referenceCondition)) {
                trueCount ++;
            }
        }        float actual = trueCount/testCase;
        float expected = (float)(rangeEnd+1-referenceCondition)/(float)(rangeEnd-rangeStart+1);
        assertThat(actual).isCloseTo(expected, Percentage.withPercentage(10));
    }

    @ParameterizedTest
    @DisplayName("범위나 조건을 잘못 지정할경우 예외를 발생시킨다")
    @CsvSource(value = {"-1,0,1", "3,2,1", "2,2,1", "2,1,2", "1,3,4", "1,3,0"})
    public void isMoveForward_ExceptionByInvalidRange(int rangeStart, int rangeEnd, int referenceCondition) {
        assertThatThrownBy(()->statusGenerator.isMoveForward(rangeStart,rangeEnd,referenceCondition)).isInstanceOf(IllegalArgumentException.class);
    }
}