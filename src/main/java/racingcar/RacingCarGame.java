package racingcar;

import racingcar.domain.CarFactory;
import racingcar.domain.RacingCar;
import racingcar.domain.RoundCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarGame {
    private int gameRounds;
    private List<RacingCar> racingCars;

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    void process(){
        initialize();
        outputView.printStart();
        playRacing();
        outputView.printWinners(getWinner());
    }

    private void initialize() {
        // 입력값을 값에 맞게 객체로 변환하는 과정 수행
        this.racingCars = CarFactory.fromString(inputView.readCarNames());
        this.gameRounds = new RoundCount(inputView.readRoundCount()).getValue();
    }

    private void playRacing() {
        for (int gameRound = 0; gameRound < this.gameRounds; gameRound++) {
            runOneRound();
        }
    }

    private void runOneRound() {
        racingCars.forEach(RacingCar::tryForward);
        outputView.printLap(racingCars);
    }

    private int maxPosition() {
        return racingCars.stream().mapToInt(RacingCar::getPosition).max().orElse(0);
    }

    private List<RacingCar> getWinner() {
        int max = maxPosition();
        return racingCars.stream()
                .filter(car -> car.getPosition() == max)
                .toList();
    }
}
