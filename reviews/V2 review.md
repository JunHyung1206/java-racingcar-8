### 모델 뷰 분리는 DTO를 통해 해결하였다.
이제 OutputView쪽에서는 RacingCar 도메인에 직접적으로 접근하지 않아도 된다. 만약 비즈니스 로직이 바뀌더라도, 주는 데이터만 변경해서 해소할 수 있다.
<br/>
```java
    @Override
    public void printWinners(List<RacingCarDTO> winnerList) {
        List<String> winnerNameList = new ArrayList<>();
        for (RacingCarDTO winner : winnerList) {
            winnerNameList.add(winner.name());
        }
        String winnerNames = String.join(", ", winnerNameList);
        System.out.println("최종 우승자 : " + winnerNames);
    }
```

### 움직임의 이동 전략을 바꿀 수 있도록 해결하였다.
- 전체 주입은 Application에서 주입 받을 수 있도록 하였다. 하지만 고민인게 게임 자체에 부합하는 것은 RacingCarGame에서 일괄적으로 처리하는게 맞는데, 차마다 다른 이동전략을 취하는게 테스트에 더 용이할 것 같기도 하다.
<br/>
```java
public interface MoveStrategy {
    int moveStep();
}

RacingCarGameController racingCarGame = new RacingCarGameController(
        new ConsoleInputView(), new ConsoleOutputView(), new ThresholdMoveStrategy());

```

### 팩토리에서도 문자열을 파싱하는 부분과 생성하는 부분을 분리할 수도 있을 것 같다.
- 결국 팩토리가 만드는 것이 역할이기 때문에 결론적으로 나누지 않기로 했다. 만든다는 하나의 책임만 수행하고 있다고 판단했기 때문이다. 나중에 팩토리가 더 커지고 비대해지면 그때 분리하면 될 것 같다.