package view;

import java.util.List;
import java.util.StringJoiner;

public class ResultOutput {

    public void resultOutput(List<String> winner) {
        final String BLANK = " ";
        final String COMMA = ",";
        final String COMMENT = "최종 우승자 : ";

        StringJoiner stringJoiner = new StringJoiner(COMMA + BLANK);

        for (String carName : winner) {
            stringJoiner.add(carName);
        }
        
        System.out.print(COMMENT + stringJoiner);
    }
}
