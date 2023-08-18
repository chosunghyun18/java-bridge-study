package bridge;

import bridge.controller.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = BridgeGame.startGame();
        bridgeGame.processGame();
        bridgeGame.showGameResult();
    }
}
