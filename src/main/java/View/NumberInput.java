package View;

import Model.NumberCheck;

import java.util.Scanner;

public class NumberInput {

    private Scanner scanner = new Scanner(System.in);
    private NumberCheck numberCheck = new NumberCheck();

    public int input() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            int number = scanner.nextInt();
            return numberCheck.numberCheck(number);
        } catch (IllegalStateException e) {
            System.out.println("[ERROR] 다시 입력해주세요.");
            return input();
        }
    }
}
