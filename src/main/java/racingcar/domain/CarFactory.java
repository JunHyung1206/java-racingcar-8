package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static List<RacingCar> fromString(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름을 입력해주세요.");
        }
        List<RacingCar> cars = new ArrayList<>();
        for (String name : input.split(",")) {
            cars.add(new RacingCar(new CarName(name)));
        }
        return cars;
    }
}

