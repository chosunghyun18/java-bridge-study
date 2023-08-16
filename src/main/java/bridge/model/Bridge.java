package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isMovementCorrect(String movement, int location) {
        ArrayList<String> bridgeCheck = new ArrayList<>(bridge);
        return bridgeCheck.get(location).equals(movement);
    }


}
