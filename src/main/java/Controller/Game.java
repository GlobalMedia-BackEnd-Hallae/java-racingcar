package Controller;

import View.CarInput;
import View.NumberInput;
import View.ProcessOutput;
import View.ResultOutput;
import Model.Car;
import Model.CreateCarClassList;
import Model.CreateWinnerList;
import Model.Move;
import java.util.List;

public class Game {

    private CarInput carInput = new CarInput();
    private NumberInput numberInput = new NumberInput();
    private CreateCarClassList createCarClassList = new CreateCarClassList();
    private Move move = new Move();
    private ProcessOutput processOutput = new ProcessOutput();
    private CreateWinnerList createWinnerList = new CreateWinnerList();
    private ResultOutput resultOutput = new ResultOutput();

    public void racingCar() {
        List<String> carList = carInput.input();
        int number = numberInput.input();
        List<Car> carClassList = createCarClassList.createCarClassList(carList);

        while (number-- != 0) {
            move.move(carClassList);
            processOutput.processOutput(carClassList);
        }

        List<String> winnerList = createWinnerList.createWinnerList(carClassList);
        resultOutput.resultOutput(winnerList);
    }
}
