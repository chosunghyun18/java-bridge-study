package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator implements BridgeNumberGenerator {
    private final List<Integer> numbers;

    public NumberGenerator(int bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        numbers = new ArrayList<>();
        for(int i =0  ; i < bridgeSize ; i++) {
            numbers.add(bridgeRandomNumberGenerator.generate());
        }
    }
    @Override
    public int generate() {
        return numbers.remove(0);
    }

}
