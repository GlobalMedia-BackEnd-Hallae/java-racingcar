package gmbs.view;

public class OutputView {

    private static final String RUN_RESULT = "실행 결과";

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printStartMessage() {
        System.out.println(RUN_RESULT);
    }

    public static void printString(String string) {
        System.out.println(string);
    }
}
