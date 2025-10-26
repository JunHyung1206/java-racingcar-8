package racingcar.dto;

public class RacingCarDTO {
    private final int position;
    private final String name;
    public RacingCarDTO(int position, String name) {
        this.position = position;
        this.name = name;
    }
    public int getPosition() {
        return position;
    }
    public String getName() {
        return name;
    }
}
