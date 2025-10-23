package racingcar.domain;

public final class CarName {
    private final String value;

    public CarName(String rawCarName) {
        if(rawCarName == null || rawCarName.trim().isEmpty()){
            throw new IllegalArgumentException("공백은 자동차의 이름이 될 수 없습니다.");
        }
        String name = rawCarName.trim();
        if (name.length() > 5) {
            throw new IllegalArgumentException("모든 자동차의 이름은 다섯글자 이하입니다." + name);
        }
        this.value = name;
    }

    public String getValue() {
        return value;
    }
}