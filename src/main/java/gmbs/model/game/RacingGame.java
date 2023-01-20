package gmbs.model.game;

import gmbs.model.car.Car;
import gmbs.model.car.collection.Cars;
import gmbs.model.condition.Condition;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final Condition moveCondition;

    public RacingGame(final String[] carNames, final Condition condition) {
        this.cars = new Cars(carNames);
        this.moveCondition = condition;
    }

    public List<Car> playRound() {
        cars.race(moveCondition);
        return cars.getCars();
    }

    public List<String> finish() {
        return cars.getWinnerCarName();
    }
}
