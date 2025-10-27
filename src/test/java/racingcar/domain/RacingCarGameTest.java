package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.move.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

class RacingCarGameTest {
    RacingCarGame racingCarGame;
    List<RacingCar> racingCarList;

    @BeforeEach
    void setUp() {
        racingCarList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            racingCarList.add(new RacingCar(new RacingCarName("car" + (i + 1))));
        }
    }

    @Test
    public void playOneLapTest() {
        racingCarGame = new RacingCarGame(racingCarList, new RunAndStopMove());
        List<RacingCar> result = racingCarGame.playOneLap();
        Assertions.assertThat(result.getFirst().getPosition()).isEqualTo(1);
        Assertions.assertThat(result.get(1).getPosition()).isEqualTo(0);
        Assertions.assertThat(result.get(2).getPosition()).isEqualTo(1);

        racingCarGame.playOneLap();
        Assertions.assertThat(result.get(1).getPosition()).isEqualTo(1);
        Assertions.assertThat(result.get(2).getPosition()).isEqualTo(1);
    }

    @Test
    public void getWinnerTest() {
        List<RacingCar> winner = null;
        racingCarList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            racingCarList.add(new RacingCar(new RacingCarName("car" + (i + 1)), i + 3));
        }
        racingCarGame = new RacingCarGame(racingCarList, new RunAndStopMove());
        winner = racingCarGame.getWinner();
        Assertions.assertThat(winner.size()).isEqualTo(1);
        Assertions.assertThat(winner.getFirst().getName()).isEqualTo("car5");


        racingCarList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (i < 3) {
                racingCarList.add(new RacingCar(new RacingCarName("car" + (i + 1)), 5));
            } else {
                racingCarList.add(new RacingCar(new RacingCarName("car" + (i + 1)), 2));
            }
        }

        racingCarGame = new RacingCarGame(racingCarList, new RunAndStopMove());
        winner = racingCarGame.getWinner();
        Assertions.assertThat(winner.size()).isEqualTo(3);

    }

    static class RunAndStopMove implements MoveStrategy {
        static int counter = 0;

        @Override
        public int moveStep() {
            counter++;
            return counter % 2;
        }
    }
}

