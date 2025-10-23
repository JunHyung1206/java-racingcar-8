package racingcar;

import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarGame racingCarGame = new RacingCarGame(new ConsoleInputView(), new ConsoleOutputView());
        racingCarGame.process();
    }
}