package racingcar.converter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.RacingCar;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    @Nested
    class ConvertCarTest{
        @Test
        @DisplayName("성공 케이스 : 이름이 하나가 입력된 경우에 변환에 성공합니다.")
        void convertNameOne() {
            List<RacingCar> racingCars = Converter.convertCarNames("abc");
            assertThat(racingCars).hasSize(1);
        }

        @Test
        @DisplayName("성공 케이스 : 이름이 여러 개 입력된 경우에 변환에 성공합니다.")
        void convertNameMany() {
            assertThat(Converter.convertCarNames("car1,car2,car3")).hasSize(3);
            assertThat(Converter.convertCarNames("test1,test2,test3,test4")).hasSize(4);
            assertThat(Converter.convertCarNames("car1,car2,car3,car4,car5")).hasSize(5);
        }

        @Test
        @DisplayName("실패 케이스 : 빈 문자열이 들어온 경우 실패합니다.")
        void convertNameEmpty() {
            assertThrows(IllegalArgumentException.class, () -> Converter.convertCarNames(""));
        }

        @Test
        @DisplayName("실패 케이스 : 빈 문자열이 들어온 경우 실패합니다.")
        void convertNameWithLongName() {
            assertThrows(IllegalArgumentException.class, () -> Converter.convertCarNames("abcdef"));
            assertThrows(IllegalArgumentException.class, () -> Converter.convertCarNames("car1,car2,LongCar3"));
        }
    }

    @Nested
    class ConvertRoundNumTest{

        @Test
        @DisplayName("실패 케이스 : 빈 문자열이 들어온 경우 실패합니다.")
        void convertNumEmpty() {
            assertThrows(IllegalArgumentException.class, () -> Converter.convertCarNames(""));
        }

        @Test
        @DisplayName("실패 케이스 : 숫자가 들어오지 않은 경우 실패합니다.")
        void convertNumNotInteger() {
            assertThrows(IllegalArgumentException.class, () -> Converter.convertGameRound(","));
        }

        @Test
        @DisplayName("실패 케이스 : 음수 혹은 0이 들어온 경우 실패합니다.")
        void convertNumNotPositiveInteger() {
            assertThrows(IllegalArgumentException.class, () -> Converter.convertGameRound("-1"));
            assertThrows(IllegalArgumentException.class, () -> Converter.convertGameRound("-4"));
            assertThrows(IllegalArgumentException.class, () -> Converter.convertGameRound("0"));

        }

    }


}