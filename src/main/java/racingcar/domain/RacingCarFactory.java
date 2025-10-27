package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class RacingCarFactory {
    public static List<RacingCar> fromString(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름을 입력해주세요.");
        }
        List<RacingCar> racingCars = new ArrayList<>();
        Set<String> seen = new HashSet<>(); // 중복 체크 용도

        for (String raw : input.split(",", -1)) {
            String name = raw.trim();
            if (!seen.add(name)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다: " + name);
            }
            racingCars.add(new RacingCar(new RacingCarName(name)));
        }
        return racingCars;
    }
}