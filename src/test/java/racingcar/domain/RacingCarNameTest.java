package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarNameTest {
    @Test
    @DisplayName("성공 케이스")
    void successName() {
        RacingCarName racingCarName = new RacingCarName("car1");
        assertThat(racingCarName).isInstanceOf(RacingCarName.class);
    }

    @Test
    @DisplayName("실패 케이스 : 긴 이름을 가진 경우")
    void longName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingCarName("LongNameCar1");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarName racingCarName2 = new RacingCarName("123456");
        });
    }

    @Test
    @DisplayName("실패 케이스 : 공백 이름을 가진 경우")
    void blankName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingCarName("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarName racingCarName = new RacingCarName(" ");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarName racingCarName = new RacingCarName("            ");
        });

    }
}