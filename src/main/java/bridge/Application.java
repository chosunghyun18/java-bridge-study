package bridge;

import bridge.controller.BridgeGame;
import bridge.model.BridgeMaker;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.gameStart();
    }
}
