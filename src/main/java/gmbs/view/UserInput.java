package gmbs.view;

import java.util.Scanner;

public class UserInput {

    private static final Scanner userInputScanner = new Scanner(System.in);

    public String userInput() {
        return userInputScanner.nextLine();
    }
}
