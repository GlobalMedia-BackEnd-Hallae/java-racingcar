package view;

import java.util.List;

public class ResultOutput {

    private static final String BLANK = " ";
    private static final String COMMA = ",";

    private void resultManyOutputs(String car, int index, int size) {
        if (index != size) {
            System.out.print(BLANK + car + COMMA);
            return;
        }

        System.out.print(BLANK + car);
    }

    public void resultOutput(List<String> winner) {
        System.out.print("최종 우승자 :");
        int size = winner.size();

        if (size == 1) {
            System.out.println(BLANK + winner.get(0));
            return;
        }

        for (int index = 0; index < size; index++) {
            resultManyOutputs(winner.get(index), index, size - 1);
        }
    }
}
