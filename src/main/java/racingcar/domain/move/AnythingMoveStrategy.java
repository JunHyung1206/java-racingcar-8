package racingcar.domain.move;

public class AnythingMoveStrategy implements MoveStrategy{
    @Override
    public int moveStep() {
        return 1;
    }
}
