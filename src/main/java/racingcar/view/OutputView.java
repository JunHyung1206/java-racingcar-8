package racingcar.view;

import java.util.List;

// view/OutputView.java
public interface OutputView {
    void printStart();
    void printLap(List<String> lapLines);
    void printWinners(List<String> winners);
}