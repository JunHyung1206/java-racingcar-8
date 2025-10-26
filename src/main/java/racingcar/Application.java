package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.domain.move.ThresholdMoveStrategy;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarGameController racingCarGame = new RacingCarGameController(
                new ConsoleInputView(), new ConsoleOutputView(), new ThresholdMoveStrategy());
        racingCarGame.process();
    }
}