package gmbs.controller;

import gmbs.model.condition.MoveCondition;
import gmbs.model.game.RacingGame;
import gmbs.model.game.vo.GameRound;
import gmbs.view.input.InputConsole;
import gmbs.view.output.OutputConsole;

public class RacingGameController {

    private final InputConsole inputConsole;
    private final OutputConsole outputConsole;
    private RacingGame racingGame;
    private GameRound gameRound;

    public RacingGameController(final InputConsole inputConsole, final OutputConsole outputConsole) {
        this.inputConsole = inputConsole;
        this.outputConsole = outputConsole;
    }

    public void run() {
        validateRacingGame();
        validateGameRound();
        startRaceWhileGameIsNotOver(racingGame, gameRound);
        outputConsole.printEndResult(racingGame.finish());
    }

    private void validateRacingGame() {
        try {
            createNewRacingGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createNewRacingGame();
        }
    }

    private void createNewRacingGame() {
        racingGame = new RacingGame(inputConsole.readCarNames(), new MoveCondition());
    }

    private void validateGameRound() {
        try {
            createNewGameRound();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createNewGameRound();
        }
    }

    private void createNewGameRound() {
        gameRound = new GameRound(inputConsole.readRound());
    }

    private void startRaceWhileGameIsNotOver(RacingGame racingGame, GameRound gameRound) {
        while (gameRound.isNotOver()) {
            outputConsole.printRoundResult(racingGame.playRound());
            gameRound.next();
        }
    }
}
