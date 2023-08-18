package bridge.controller;

import bridge.domain.BridgeBuilder;
import bridge.domain.UserResult;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> answerBridge;
    private final UserResult user;
    private final OutputController outputController;
    private final InputController inputController;

    private BridgeGame() {
        user = new UserResult();
        outputController = new OutputController();
        inputController = new InputController();
        outputController.printStartInfoMessage();
        makeBridge();
    }

    public static BridgeGame startGame() {
        return new BridgeGame();
    }

    private void makeBridge() {
        outputController.printBridgeSizeInfoMessage();
        int givenBridgeLength = inputController.readBridgeSize();
        answerBridge = BridgeBuilder.makeAnswerBridge(givenBridgeLength);
    }

    public void processGame() {
        String gameCommand = "R";
        while (gameCommand.equals("R")) {
            initUserResult();
            boolean completeStage = moveOverBridge();
            if (completeStage) gameCommand = "Q";
            if (!completeStage) gameCommand = retry();
        }
    }

    private void initUserResult() {
        user.initBridgeForGame();
    }

    private boolean moveOverBridge() {
        int round = 0;
        while (user.isCrossEntireBridge(answerBridge)) {
            outputController.printMoveInfoMessage();
            String moveCommand = inputController.readNextMove();
            if (!move(moveCommand, round)) return false;
            round++;
        }
        return true;
    }

    private boolean move(String moveCommand, int round) {
        boolean canGo = user.moveNextStep(moveCommand, nextAnswerStep(round));
        outputController.printUserBridge(user);
        return canGo;
    }

    private String nextAnswerStep(int round) {
        return answerBridge.get(round);
    }

    private String retry() {
        outputController.printRestartInputInfoMessage();
        return inputController.readGameCommand();
    }

    public void showGameResult() {
        outputController.printResult(user);
    }
}
