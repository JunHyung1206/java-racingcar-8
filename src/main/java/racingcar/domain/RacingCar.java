package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private final CarName name;
    private int position;

    public RacingCar(CarName name) {
        this.name = name;
        position = 0;
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }

    public void tryForward(){
        if(Randoms.pickNumberInRange(0, 9) >= 4){
            position++;
        }
    }
}
