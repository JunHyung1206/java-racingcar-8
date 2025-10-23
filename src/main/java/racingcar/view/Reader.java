package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Reader {
    public static String[] inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        return carNames.split(",");
    }

    public static String inputGameRounds(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String gameRounds = Console.readLine();
        return gameRounds;
    }
}