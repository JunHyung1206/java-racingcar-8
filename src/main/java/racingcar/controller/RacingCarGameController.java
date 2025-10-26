package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarFactory;

import racingcar.domain.RacingCarGame;
import racingcar.domain.RoundCount;
import racingcar.domain.move.MoveStrategy;
import racingcar.domain.move.ThresholdMoveStrategy;
import racingcar.dto.RacingCarDTO;
import racingcar.mapper.RacingCarMapper;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;


public class RacingCarGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MoveStrategy moveStrategy;

    public RacingCarGameController(InputView inputView, OutputView outputView, MoveStrategy moveStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.moveStrategy = moveStrategy;
    }

    public void process() {
        RacingCarGame racingCarGame = new RacingCarGame(RacingCarFactory.fromString(inputView.readCarNames()), moveStrategy);
        RoundCount roundCount = new RoundCount(inputView.readRoundCount());
        outputView.printStart();

        for (int round = 0; round < roundCount.getValue(); round++) {
            List<RacingCar> racingCars = racingCarGame.playOneLap();
            outputView.printLap(RacingCarMapper.toRacingCarDTOList(racingCars));
        }

        List<RacingCarDTO> winnerList = RacingCarMapper.toRacingCarDTOList(racingCarGame.getWinner());
        outputView.printWinners(winnerList);
    }
}
