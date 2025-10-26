package racingcar.controller;

import racingcar.domain.RacingCarFactory;
import racingcar.domain.RacingCar;
import racingcar.domain.RoundCount;
import racingcar.mapper.RacingCarMapper;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.List;

public class RacingCarGameController {
    private int roundCounts;
    private List<RacingCar> racingCars;

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void process() {
        initialize();
        outputView.printStart();
        playRacing();
        outputView.printWinners(RacingCarMapper.toRacingCarDTOList(getWinner()));
    }

    private void initialize() {
        // 입력값을 값에 맞게 객체로 변환하는 과정 수행
        this.racingCars = RacingCarFactory.fromString(inputView.readCarNames());
        this.roundCounts = new RoundCount(inputView.readRoundCount()).getValue();
    }

    private void playRacing() {
        for (int round = 0; round < this.roundCounts; round++) {
            runOneRound();
        }
    }

    private void runOneRound() {
        racingCars.forEach(RacingCar::tryForward);
        outputView.printLap(RacingCarMapper.toRacingCarDTOList(racingCars));
    }

    private int maxPosition() {
        return racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);
    }

    private List<RacingCar> getWinner() {
        int max = maxPosition();
        return racingCars.stream()
                .filter(car -> car.getPosition() == max)
                .toList();
    }
}
