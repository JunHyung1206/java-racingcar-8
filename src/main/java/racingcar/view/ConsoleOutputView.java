package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.dto.RacingCarDTO;

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
            System.out.println(racingCar.getName() + " : " + "-".repeat(racingCar.getPosition()));
        }
        System.out.println();
    }

    @Override
    public void printWinners(List<RacingCarDTO> winnerList) {
        String winnerNames = String.join(", ", winnerList.stream().map(RacingCarDTO::getName).toList());
        System.out.println("최종 우승자 : " + winnerNames);
    }

}
