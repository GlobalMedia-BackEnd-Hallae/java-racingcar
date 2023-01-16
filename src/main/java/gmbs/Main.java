package gmbs;

import gmbs.controller.RacingGameController;
import gmbs.view.input.InputConsole;
import gmbs.view.input.InputConsoleImpl;
import gmbs.view.output.OutputConsole;
import gmbs.view.output.OutputConsoleImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputConsole inputConsole =  new InputConsoleImpl(scanner);
        OutputConsole outputConsole = new OutputConsoleImpl();
        RacingGameController racingGameController = new RacingGameController(inputConsole, outputConsole);
        racingGameController.run();
    }
}