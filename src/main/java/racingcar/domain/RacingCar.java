package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private final RacingCarName name;
    private int position;

    public RacingCar(RacingCarName name) {
        this.name = name;
        position = 0;
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(int step) {
        position += step;
    }
}
