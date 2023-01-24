package gmbs.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gmbs.util.RandomGenerator;

import static gmbs.util.StringUtils.splitByDelimiter;
import static gmbs.util.StringUtils.stripStringArray;

public class Cars {
    private static final String DELIMITER = ",";
    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final String DUPLICATED_NAME_MESSAGE = "[ERROR] 중복된 이름이 있습니다";
    private final List<Car> cars;

    public Cars(String carNames) {
        String[] carNameArray = stripStringArray(splitByDelimiter(carNames, DELIMITER));
        List<Car> cars = new ArrayList<>();
        validateDuplicatedName(carNameArray);
        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
        this.cars = cars;
    }

    private void validateDuplicatedName(String[] carNames) {
        long distinctSize = Arrays.stream(carNames)
                .distinct()
                .count();
        if (distinctSize != carNames.length) {
            throw new IllegalArgumentException(DUPLICATED_NAME_MESSAGE);
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move(RandomGenerator.generateNumber(MIN, MAX + 1));
        }
    }

    public Winners getWinners() {
        return new Winners(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
