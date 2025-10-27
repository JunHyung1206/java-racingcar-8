package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarFactoryTest {
    @Test
    @DisplayName("성공 케이스 : 각 레이싱카 경주를 위해서는 한개 이상의 레이싱카가 필요하다.")
    void successCase() {
        List<RacingCar> racingCars1 = RacingCarFactory.fromString("car1");
        assertThat(racingCars1).hasSize(1);

        List<RacingCar> racingCars2 = RacingCarFactory.fromString("car1,car2");
        assertThat(racingCars2).hasSize(2);
        List<RacingCar> racingCars3 = RacingCarFactory.fromString("car1,car2,car3");
        assertThat(racingCars3).hasSize(3);
    }

    @Test
    @DisplayName("실패 케이스 : 레이싱카 입력이 없는 경우")
    void noRacingCar() {
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarFactory.fromString("");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarFactory.fromString(" ");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarFactory.fromString("  ");
        });
    }


    @Test
    @DisplayName("실패 케이스 : 레이싱카 입력 중 유효하지 않은 이름이 입력된 경우")
    void inValidRacingCarName() {
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarFactory.fromString("123456");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarFactory.fromString("car1,car2,      ");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarFactory.fromString("car1,car2,");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarFactory.fromString(" racingCar1,car2");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarFactory.fromString("   ,car2");
        });
    }

    @Test
    @DisplayName("실패 케이스 : 레이싱카 입력 중 중복된 이름이 입력된 경우")
    void duplicateRacingCarName() {
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarFactory.fromString("car,car,car2");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarFactory.fromString("car2,car,car2");
        });
    }



}