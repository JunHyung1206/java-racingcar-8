package racingcar.view;

import racingcar.domain.RacingCar;
import java.util.List;

public interface OutputView {
    void printStart();

    void printLap(List<RacingCar> racingCarList);

    void printWinners(List<RacingCar> winnerList);
}