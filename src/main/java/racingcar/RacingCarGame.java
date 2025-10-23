package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.Reader;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private int gameRounds;
    private List<RacingCar> racingCars;

    RacingCarGame(){
        gameRounds = 0;
        racingCars = new ArrayList<>();
    }
    void process(){
        // TODO: 프로그램 구현
        String[] carNames = Reader.inputCarNames();
        String gameRounds = Reader.inputGameRounds();

        // TODO: 입력값이 유효한지 검증을 하는 단계 필요

        // 입력값을 값에 맞게 객체로 변환하는 과정 수행
        for (String carName : carNames) {
            this.racingCars.add(new RacingCar(carName));
        }
        this.gameRounds = Integer.parseInt(gameRounds);


    }
}
