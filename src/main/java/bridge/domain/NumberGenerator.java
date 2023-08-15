package bridge.domain;

import java.util.List;

public class NumberGenerator implements BridgeNumberGenerator {
    private final List<Integer> numbers;
    NumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }
    @Override
    public int generate() {
        return numbers.remove(0);
    }

}
