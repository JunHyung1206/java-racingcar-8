package racingcar.view;

import racingcar.dto.RacingCarDTO;

import java.util.ArrayList;
import java.util.List;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    @Override
    public void printLap(List<RacingCarDTO> racingCarList) {
        for (RacingCarDTO racingCar : racingCarList) {
            System.out.println(racingCurrentState(racingCar));
        }
        System.out.println();
    }

    @Override
    public void printWinners(List<RacingCarDTO> winnerList) {
        List<String> winnerNameList = new ArrayList<>();
        for (RacingCarDTO winner : winnerList) {
            winnerNameList.add(winner.getName());
        }
        String winnerNames = String.join(", ", winnerNameList);
        System.out.println("최종 우승자 : " + winnerNames);
    }

    private String racingCurrentState(RacingCarDTO racingCar) {
        return racingCar.getName() + " : " + "-".repeat(racingCar.getPosition());
    }
}
