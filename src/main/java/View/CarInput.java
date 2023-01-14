package View;

import Model.CarCheck;

import java.util.List;
import java.util.Scanner;

public class CarInput {

    private Scanner scanner = new Scanner(System.in);
    private CarCheck carCheck = new CarCheck();

    public List<String> input() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String car = scanner.nextLine();
            return carCheck.carCheck(car);
        } catch (IllegalStateException e) {
            System.out.println("[ERROR] 다시 입력해주세요.");
            return input();
        }
    }
}
