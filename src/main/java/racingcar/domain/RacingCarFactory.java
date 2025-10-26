package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarFactory {
    public static List<RacingCar> fromString(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름을 입력해주세요.");
        }
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : input.split(",", -1)) {
            racingCars.add(new RacingCar(new RacingCarName(name.trim())));
        }
        return racingCars;
    }
}