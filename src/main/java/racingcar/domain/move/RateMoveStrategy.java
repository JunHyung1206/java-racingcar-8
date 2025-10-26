package racingcar.domain.move;

import camp.nextstep.edu.missionutils.Randoms;

public class RateMoveStrategy implements MoveStrategy {
    @Override
    public int moveStep() {
        int stepFactor = Randoms.pickNumberInRange(0, 9);
        if (stepFactor >= 7) {
            return 2;
        } else if (stepFactor >= 5) {
            return 1;
        } else {
            return 0;
        }
    }
}
