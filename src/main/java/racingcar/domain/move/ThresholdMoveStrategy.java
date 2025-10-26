package racingcar.domain.move;

import camp.nextstep.edu.missionutils.Randoms;

public class ThresholdMoveStrategy implements MoveStrategy {
    @Override
    public int moveStep() {
        int stepFactor = Randoms.pickNumberInRange(0, 9);
        if(stepFactor >= 4){
            return 1;
        } else{
            return 0;
        }
    }
}
