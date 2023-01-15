package gmbs.controller;

import gmbs.model.Cars;
import gmbs.model.TryNumber;
import gmbs.view.InputView;
import gmbs.view.OutputView;

public class RacingController {
    private Cars cars;
    private TryNumber tryCount;

    public void start() {
        try {
            cars = new Cars(InputView.inputCarNames());
            inputTryCount();
            race();
            terminate();
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            start();
        }
    }

    private void inputTryCount() {
        try {
            tryCount = new TryNumber(InputView.inputTryCount());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            inputTryCount();
        }
    }

    private void race() {
        int nowTryCnt = 0;
        OutputView.printStartMessage();
        while (tryCount.isNotSame(nowTryCnt++)) {
            cars.moveAll();
            OutputView.printString(cars.toString());
        }
    }

    private void terminate() {
        OutputView.printString(cars.toString());
        OutputView.printString(cars.getWinners().toString());
    }
}
