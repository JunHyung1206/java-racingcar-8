package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private final RacingCarName name;
    private int position;

    public RacingCar(RacingCarName name) {
        this(name, 0);
    }

    public RacingCar(RacingCarName name, int position) {
        this.name = name;
        this.position = position;
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
