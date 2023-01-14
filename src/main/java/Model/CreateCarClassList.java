package Model;

import java.util.ArrayList;
import java.util.List;

public class CreateCarClassList {

    private List<Car> carClassList = new ArrayList<>();

    public List<Car> createCarClassList(List<String> carList) {

        for (int index = 0; index < carList.size(); index++) {
            carClassList.add(new Car(carList.get(index)));
        }

        return carClassList;
    }
}
