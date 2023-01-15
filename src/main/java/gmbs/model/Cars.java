package gmbs.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gmbs.util.RandomGenerator;

import static java.lang.System.lineSeparator;

public class Cars {
    private static final String DELIMITER = ",";
    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final String DUPLICATED_NAME_MESSAGE = "[ERROR] 중복된 이름이 있습니다";
    private final List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {

        String[] carNameArray = reduceBlank(carNames).split(DELIMITER);
        validateDuplicatedName(carNameArray);
        for (String carName : carNameArray) {
            cars.add(new Car(carName));
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.toString()).append(lineSeparator());
        }
        return sb.toString();
    }

    private void validateDuplicatedName(String[] carNames) {
        long distinctSize = Arrays.stream(carNames).distinct().count();
        if (distinctSize != carNames.length) {
            throw new IllegalArgumentException(DUPLICATED_NAME_MESSAGE);
        }
    }

    private String reduceBlank(String string) {
        return string.replace(" ", "");
    }
}
