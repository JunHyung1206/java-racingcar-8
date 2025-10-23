package racingcar.domain;

public final class RoundCount {
    private final int value;
    public RoundCount(String rawRoundCount) {
        if (rawRoundCount == null || rawRoundCount.trim().isEmpty()) {
            throw new IllegalArgumentException("시도할 횟수를 입력해주세요.");
        }
        try {
            int v = Integer.parseInt(rawRoundCount.trim());
            if (v <= 0) {
                throw new IllegalArgumentException("시도할 횟수는 양수여야 합니다.");
            }
            this.value = v;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
    }
    public int getValue() {
        return value;
    }
}