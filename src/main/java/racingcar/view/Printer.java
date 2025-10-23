package racingcar.view;

import racingcar.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class Printer {
    public static void printGameRacing(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.println(racingCar.getCurrentResult());
        }
        System.out.println();
    }

    public static void printWinner(List<RacingCar> racingGameWinners) {
        List<String> winners = new ArrayList<>();
        for (RacingCar racingCar : racingGameWinners) {
            winners.add(racingCar.getName());
        }

        System.out.print("최종 우승자 : ");
        String winnerNames = String.join(", ",winners);
        System.out.println(winnerNames);
    }
}
