### Domain객체를 View에서 사용하고 있다.
Console ↔ RacingCarGame ↔ RacingCar

- RacingCarGame이 콘솔 뷰에 있는 정보를 들고와서 이를 처리하는 컨트롤러 역할을 한다.
- 하지만 OutputView를 보면 RacingCar객체를 직접 처리하는 것을 볼 수 있다. 모델 - 뷰 분리 원칙에서는 뷰에서는 도메인의 정보를 전혀 몰라야한다, 이를 어떻게 해결 할 수 있을지에 대해서 공부가 필요하다.

```java
    @Override
    public void printLap(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            System.out.println(racingCar.getName() + " : " + "-".repeat(racingCar.getPosition()));
        }
        System.out.println();
    }

    @Override
    public void printWinners(List<RacingCar> winnerList) {
        String winnerNames = String.join(", ", winnerList.stream().map(RacingCar::getName).toList());
        System.out.println("최종 우승자 : " + winnerNames);
    }
```
<br/>

### 움직임의 이동 전략은 바뀔 수 있다.
- 현재 4이상일 때만 움직이고 있는 전략을 사용하고 있지만 이 전략이 바뀔 수도 있다. 확률을 변경할 수도 있고, 각 값마다 움직이는 양이 다를 수도 있다. 이를 바로바로 바꿀 수 있도록 리펙토링 하는 과정이 필요할 수 있지 않을까? 전략 패턴을 사용해보자

```java
    public void tryForward(){
        if(Randoms.pickNumberInRange(0, 9) >= 4){
            position++;
        }
    }
```
<br/>


### 팩토리에서도 문자열을 파싱하는 부분과 생성하는 부분을 분리할 수도 있을 것 같다.

- 우선 간단한 객체는 크리에이터가, 복잡한 것은 팩토리가 만들도록 하려고 했다. RacingCar 객체는 비교적 복잡하니까 팩토리를 두기로 하였는데, 파싱하는 부분과 생성하는 부분을 서로 분리한다면, 위의 모델 뷰 분리하는 것에 있어 좀 더 효과적이지 않을까 고민이 된다.
- 사실 이 뷰에서 모델로 넘어오는 데이터 형태가 일관적이라면 더 효과적일텐데, 이 변환하는 과정을 어디다가 넣어야할지가 고민이다.