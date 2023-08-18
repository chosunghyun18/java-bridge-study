package bridge.domain;

import java.util.List;

public interface BridgeBuilder {
    static List<String> makeAnswerBridge(int givenBridgeLength) {
        return BridgeMaker.makeAnswerBridge(givenBridgeLength);
    }
}
