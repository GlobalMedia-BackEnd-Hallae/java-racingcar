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
}
