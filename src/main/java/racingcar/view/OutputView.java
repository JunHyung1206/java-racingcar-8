package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.dto.RacingCarDTO;

import java.util.List;

public interface OutputView {
    void printStart();

    void printLap(List<RacingCarDTO> racingCarList);

    void printWinners(List<RacingCarDTO> winnerList);
}