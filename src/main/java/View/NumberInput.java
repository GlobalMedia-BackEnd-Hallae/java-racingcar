package view;

import java.util.Scanner;

public class NumberInput {

    private Scanner scanner = new Scanner(System.in);

    public int inputNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public void reportError() {
        System.out.println("[ERROR] 다시 입력해주세요.");
    }
}
