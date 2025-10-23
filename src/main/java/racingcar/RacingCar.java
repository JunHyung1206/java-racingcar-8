package racingcar;

public class RacingCar {
    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(){
        position++;
    }

    public String getCurrentResult(){
        return name + " : " + "-".repeat(position);
    }
}
