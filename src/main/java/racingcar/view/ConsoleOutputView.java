package racingcar.view;

import racingcar.RacingCar;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printStart() {

    }

    @Override
    public void printLap(List<String> lapLines) {

    }

    @Override
    public void printWinners(List<String> winners) {

    }

    public static void printGameRacing(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.println(racingCar.getCurrentResult());
        }
        System.out.println();
    }

    public static void printWinner(List<RacingCar> racingGameWinners) {
        String winnerNames = String.join(", ", racingGameWinners.stream().map(RacingCar::getName).toList());
        System.out.println("최종 우승자 : " + winnerNames);
    }

    public static void printStartRacing(){
        System.out.println();
        System.out.println("실행 결과");
    }
}
