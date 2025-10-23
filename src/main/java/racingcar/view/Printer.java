package racingcar.view;

import racingcar.RacingCar;

import java.util.List;

public class Printer {
    public static void printGameRacing(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.println(racingCar.getCurrentResult());
        }
    }
}
