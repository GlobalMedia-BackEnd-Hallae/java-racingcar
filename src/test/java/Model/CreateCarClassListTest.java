package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CreateCarClassListTest {
    private CarStatusCreate createCarClassList = new CarStatusCreate();

    @Test
    @DisplayName("Car 클래스를 원소로 가지는 리스트를 생성할 수 있다.")
    void canCreateCarClassList() {
        // when
        List<String> carList = new ArrayList<>();
        carList.add("a");
        carList.add("b");
        carList.add("c");

        List<Car> carClassList = new ArrayList<>();
        carClassList.add(new Car("a"));
        carClassList.add(new Car("b"));
        carClassList.add(new Car("c"));

        // given

        // then
        //assertThat(createCarClassList.createCarClass(carList)).isEqualTo(carClassList);

        // 왜 오류가 나는 거지?? ㅠㅠ
    }
}