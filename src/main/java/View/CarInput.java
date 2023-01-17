package view;

import java.util.Scanner;

public class CarInput {

    private Scanner scanner = new Scanner(System.in);

    public void reportError() {
        System.out.println("[ERROR] 다시 입력해주세요.");
    }

    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return scanner.nextLine();
    }
}
