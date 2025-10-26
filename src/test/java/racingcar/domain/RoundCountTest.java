package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoundCountTest {
    @Test
    @DisplayName("성공 케이스")
    void successCase() {
        RoundCount roundCount = new RoundCount("10");
        assertThat(roundCount).isInstanceOf(RoundCount.class);
        assertThat(roundCount.getValue()).isEqualTo(10);
    }

    @Test
    @DisplayName("실패 케이스 : 정수가 아닌경우")
    void notInteger() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RoundCount("10.1");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            RoundCount roundCount = new RoundCount("a");
        });
    }

    @Test
    @DisplayName("실패 케이스 : 양수가 아닌 경우")
    void blankName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RoundCount("-1");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            RoundCount roundCount = new RoundCount("0");
        });
    }
}