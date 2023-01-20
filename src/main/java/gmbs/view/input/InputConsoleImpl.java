package gmbs.view.input;

import java.util.Scanner;

public class InputConsoleImpl implements InputConsole {

    private static final String NAME_DELIMITER = ",";

    private final Scanner scanner;

    public InputConsoleImpl(final Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String[] readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return scanner.nextLine().split(NAME_DELIMITER);
    }

    @Override
    public int readRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}
