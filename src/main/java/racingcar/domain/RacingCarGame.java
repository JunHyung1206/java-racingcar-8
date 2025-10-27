package racingcar.domain;

import racingcar.domain.move.MoveStrategy;

import java.util.List;

public class RacingCarGame {
    private final List<RacingCar> racingCars;
    private final MoveStrategy moveStrategy;

    public RacingCarGame(List<RacingCar> racingCars, MoveStrategy moveStrategy) {
        this.racingCars = racingCars;
        this.moveStrategy = moveStrategy;
    }

    public List<RacingCar> playOneLap() {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveForward(moveStrategy.moveStep());
        }
        return racingCars;
    }

    private int maxPosition() {
        return racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);
    }

    public List<RacingCar> getWinner() {
        int max = maxPosition();
        return racingCars.stream()
                .filter(car -> car.getPosition() == max)
                .toList();
    }
}
