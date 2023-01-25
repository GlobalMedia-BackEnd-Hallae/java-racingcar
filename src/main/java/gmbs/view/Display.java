package gmbs.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Display {

    private String distance(int position) {
        String distanceMark = "-";
        return distanceMark.repeat(position);
    }

    public void showStatus(Map<String, Integer> carStatus) {
        List<String> carNames = new ArrayList<>(carStatus.keySet());
        for (String name : carNames) {
            String position = distance(carStatus.get(name));
            System.out.println(name + " : " + position);
        }
        System.out.println(System.lineSeparator());
    }

    public void showWinners(List<String> headPositionNames) {
        String winnerNames = headPositionNames.toString().replace("[", "").replace("]", "");
        System.out.println("우승자는,,,,    " + winnerNames);
    }

    public void showStartDisplay() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showRepeatDisplay() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
