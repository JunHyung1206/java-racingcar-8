package racingcar.converter;

import racingcar.RacingCar;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static List<RacingCar> convertCarNames(String rawCarNames) {
        validateCarNames(rawCarNames);
        return Arrays.stream(rawCarNames.split(",")).map(RacingCar::new).collect(Collectors.toList());
    }

    public static int convertGameRound(String rawGameRound){
        validateGameRound(rawGameRound);
        return Integer.parseInt(rawGameRound);
    }

    private static void validateCarNames(String rawCarNames) {
        if(rawCarNames == null || rawCarNames.trim().isEmpty()){
            throw new IllegalArgumentException("시도할 횟수를 입력해주세요.");
        }
        List<String> carNames = Arrays.stream(rawCarNames.split(",")).toList();
        if(carNames.stream().anyMatch(String::isEmpty)){
            throw new IllegalArgumentException("공백은 자동차의 이름이 될 수 없습니다.");
        }
        if(carNames.stream().anyMatch(carName -> carName.length() > 5)){
            throw new IllegalArgumentException("모든 자동차의 이름은 다섯글자 이하입니다.");
        }
    }

    private static void validateGameRound(String rawGameRound) {
        if(rawGameRound == null || rawGameRound.trim().isEmpty()){
            throw new IllegalArgumentException("시도할 횟수를 입력해주세요.");
        }
        int gameRound;
        try{
            gameRound = Integer.parseInt(rawGameRound);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
        if(gameRound <= 0){
            throw new IllegalArgumentException("시도할 횟수는 양수여야 합니다.");
        }
    }
}
