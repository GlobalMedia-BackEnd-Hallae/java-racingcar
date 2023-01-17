package controller;

import model.*;
import view.CarInput;
import view.NumberInput;
import view.ProcessOutput;
import view.ResultOutput;

import java.util.List;

public class Game {

    private CarInput carInput = new CarInput();
    private CarNameCheck carNameCheck = new CarNameCheck();
    private CarStatusCreate createCarClass = new CarStatusCreate();
    private NumberInput numberInput = new NumberInput();
    private NumberCheck numberCheck = new NumberCheck();
    private CarPositionMove carPositionMove = new CarPositionMove();
    private ProcessOutput processOutput = new ProcessOutput();
    private WinnerCreate createWinner = new WinnerCreate();
    private ResultOutput resultOutput = new ResultOutput();

    private List<String> inputAndCheckCarName() {
        try {
            return carNameCheck.checkCarName(carInput.inputCarName());
        } catch (IllegalStateException exception) {
            carInput.reportError();
            return inputAndCheckCarName();
        }
    }

    private int inputAndCheckNumber() {
        try {
            return numberCheck.numberCheck(numberInput.inputNumber());
        } catch (IllegalStateException exception) {
            numberInput.reportError();
            return inputAndCheckNumber();
        }
    }

    public void racingCar() {
        List<Car> carStatus = createCarClass.createCarStatus(inputAndCheckCarName());
        int number = inputAndCheckNumber();

        while (number-- != 0) {
            carPositionMove.move(carStatus);
            processOutput.processOutput(carStatus);
        }

        List<String> winner = createWinner.createWinner(carStatus);
        resultOutput.resultOutput(winner);
    }
}
