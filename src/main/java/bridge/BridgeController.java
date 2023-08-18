package bridge;

import View.InputView;
import View.OutputView;

import java.util.List;

public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final String wrong = "X";
    private final String gameEnd = "Q";
    private int bridgeSize;
    private BridgeGame bridgeGame = null;
    private int tryCount = 0;

    public int readSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            }
            catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
            outputView.printSize();
        }
    }
    public List<List<String>> readMoving() {
        while (true) {
            try {
                return bridgeGame.move(inputView.readMoving());
            }
            catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
            outputView.printMoving();
        }
    }
    public String readGameCommand() {
        while (true) {
            try {
                return inputView.readGameCommand();
            }
            catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
            outputView.printRestart();
        }
    }
    public boolean gameEndCheck() {
        outputView.printRestart();
        String gameCommand = readGameCommand();
        if (gameCommand.equals(gameEnd)) {
            return false;
        }
        this.bridgeGame.retry();
        return true;
    }
    public boolean playBridgeGame() {
        while(true) {
            outputView.printMoving();
            List<List<String>> currentMap = readMoving();
            outputView.printMap(currentMap);
            if (currentMap.get(currentMap.size() - 1).contains(wrong)) {
                gameEndCheck();
            }
            if (bridgeSize == currentMap.size()) {
                return false;
            }
        }
    }
    public void startBridgeController() {
        outputView.printStart();
        outputView.printSize();
        bridgeSize = readSize();
        bridgeGame = new BridgeGame(bridgeSize);
        boolean retryFlag = true;
        while (retryFlag) {
            try {
                retryFlag = playBridgeGame();
            }
            catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
            tryCount++;
        }
        outputView.printResult(bridgeGame.gameEnd(), bridgeGame.gameResult(), tryCount);
    }
}
