package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    @Override
    public void printLap(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            System.out.println(racingCar.getName() + " : " + "-".repeat(racingCar.getPosition()));
        }
        System.out.println();
    }

    @Override
    public void printWinners(List<RacingCar> winnerList) {
        String winnerNames = String.join(", ", winnerList.stream().map(RacingCar::getName).toList());
        System.out.println("최종 우승자 : " + winnerNames);
    }

}
