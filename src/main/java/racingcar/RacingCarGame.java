package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.converter.Converter;
import racingcar.view.Printer;
import racingcar.view.Reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarGame {

    private int gameRounds;
    private List<RacingCar> racingCars;
    private int leadPosition;

    RacingCarGame(){
        gameRounds = 0;
        leadPosition = 0;
    }

    void process(){
        initialize();
        playRacing();
        Printer.printWinner(getWinner());
    }

    private void initialize() {
        // 입력값을 값에 맞게 객체로 변환하는 과정 수행
        this.racingCars = Converter.convertCarNames(Reader.inputCarNames());
        this.gameRounds = Converter.convertGameRound(Reader.inputGameRounds());
    }

    private void playRacing() {
        Printer.printStartRacing();
        for (int gameRound = 0; gameRound < this.gameRounds; gameRound++) {
            runOneRound();
            Printer.printGameRacing(this.racingCars);
        }
    }

    private void runOneRound() {
        for (RacingCar racingCar : racingCars) {
            if(isMoveForward()){
                racingCar.moveForward();
            }
            leadPosition = Math.max(leadPosition, racingCar.getPosition());
        }
    }

    private List<RacingCar> getWinner() {
        return racingCars.stream().filter(racingCar -> racingCar.getPosition() == leadPosition).toList();
    }

    private boolean isMoveForward() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
