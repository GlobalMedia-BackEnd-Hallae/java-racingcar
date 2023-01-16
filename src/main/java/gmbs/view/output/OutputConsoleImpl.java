package gmbs.view.output;

import gmbs.model.car.Car;

import java.util.List;

public class OutputConsoleImpl implements OutputConsole {

    private static final String DISTANCE_DELIMITER = "-";
    private static final String CAR_NAME_POSITION_DELIMITER = ":";
    private static final String WINNER_DELIMITER = ",";
    private static final String LINE_BREAK = "\n";

    @Override
    public void printRoundResult(List<Car> cars) {
        StringBuilder roundResult = new StringBuilder();
        cars.forEach(car -> roundResult
                        .append(car.getNameValue())
                        .append(CAR_NAME_POSITION_DELIMITER)
                        .append(DISTANCE_DELIMITER.repeat(car.getPositionValue()))
                        .append(LINE_BREAK)
                );
        System.out.println(roundResult);
    }

    @Override
    public void printEndResult(List<String> winnerCarNames) {
        StringBuilder endResult = new StringBuilder();
        endResult.append("최종 우승자 : ");

        winnerCarNames.forEach(name -> endResult.append(name).append(WINNER_DELIMITER));
        endResult.deleteCharAt(endResult.lastIndexOf(WINNER_DELIMITER));

        System.out.println(endResult);
    }
}

