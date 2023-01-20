package controller;

import model.*;
import view.CarInput;
import view.NumberInput;
import view.ProcessOutput;
import view.ResultOutput;

import java.util.List;

public class Game {

    private CarInput carInput = new CarInput();
    private CarNameSplit carNameSplit = new CarNameSplit();
    private CarStatusCreate createCarStatus = new CarStatusCreate();
    private NumberInput numberInput = new NumberInput();
    private NumberCheck numberCheck = new NumberCheck();
    private CarPositionMove carPositionMove = new CarPositionMove();
    private ProcessOutput processOutput = new ProcessOutput();
    private WinnerCreate winnerCreate = new WinnerCreate();
    private ResultOutput resultOutput = new ResultOutput();

    public void racingCar() {
        final int GAME_END = 0;

        List<Car> carStatus = inputAndCheckCarName();
        int number = inputAndCheckNumber();

        while (number-- != GAME_END) {
            carPositionMove.move(carStatus);
            processOutput.processOutput(carStatus);
        }

        resultOutput.resultOutput(winnerCreate.createWinner(carStatus));
    }

    private List<Car> inputAndCheckCarName() {
        try {
            return createCarStatus.createCarStatus(carNameSplit.splitCarName(carInput.inputCarName()));
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
}
