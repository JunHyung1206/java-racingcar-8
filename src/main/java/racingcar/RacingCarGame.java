package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.Printer;
import racingcar.view.Reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarGame {

    private int gameRounds;
    private final List<RacingCar> racingCars;

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
        Arrays.stream(carNames).forEach(carName -> this.racingCars.add(new RacingCar(carName)));
        this.gameRounds = Integer.parseInt(gameRounds);


        System.out.println();
        System.out.println("실행 결과");
        
        for (int gameRound = 0; gameRound < this.gameRounds; gameRound++) {
            runOneRound();
            Printer.printGameRacing(this.racingCars);
        }

        Printer.printWinner(getWinner());
    }

    private void runOneRound() {
        for (RacingCar racingCar : racingCars) {
            if(isMoveForward()){
                racingCar.moveForward();
            }
        }
    }

    private List<RacingCar> getWinner() {
        List<RacingCar> winners = new ArrayList<>();
        int winnerPosition = 0;
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() > winnerPosition) {
                winnerPosition = racingCar.getPosition();
            }
        }

        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() == winnerPosition) {
                winners.add(racingCar);
            }
        }
        return winners;
    }

    private boolean isMoveForward() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
