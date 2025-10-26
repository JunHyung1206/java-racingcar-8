package racingcar.mapper;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarName;
import racingcar.dto.RacingCarDTO;

import java.util.ArrayList;
import java.util.List;

public class RacingCarMapper {

    public static RacingCar fromRacingCarDTO(RacingCarDTO racingCarDTO) {
        RacingCarName carName = new RacingCarName(racingCarDTO.getName());
        return new RacingCar(carName);
    }

    public static RacingCarDTO toRacingCarDTO(RacingCar racingCar) {
        return new RacingCarDTO(racingCar.getPosition(), racingCar.getName());
    }

    public static List<RacingCarDTO> toRacingCarDTOList(List<RacingCar> racingCar) {
        List<RacingCarDTO> racingCarDTOList = new ArrayList<>();
        for (RacingCar car : racingCar) {
            racingCarDTOList.add(toRacingCarDTO(car));
        }
        return racingCarDTOList;
    }

}

