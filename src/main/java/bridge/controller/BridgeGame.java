package bridge.controller;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;

import bridge.domain.NumberGenerator;

import bridge.domain.UserResult;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final UserResult user;
    private List<String> answerBridge ;
    private int bridgeLength;
    private final OutputController outputController;
    private final InputController inputController;
    private BridgeGame() {
        outputController = new OutputController();
        answerBridge = new ArrayList<>();
        inputController = new InputController();
        user = new UserResult();
        outputController.printStartInfoMessage();
        makeBridge();
    }
    public static BridgeGame startGame() {
        return new BridgeGame();
    }

    private void makeBridge() {
        outputController.printBridgeSizeInfoMessage();
        bridgeLength = inputController.readBridgeSize();
        BridgeNumberGenerator numberGenerator = new NumberGenerator(bridgeLength);
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        answerBridge = bridgeMaker.makeBridge(bridgeLength);
    }
    public void processGame() {
        String gameCommand = "R";
        while (gameCommand.equals("R")) {
            initUserResult();
            boolean completeStage = moveOverBridge();
            if(completeStage) gameCommand = "Q";
            if(!completeStage) gameCommand = retry();
        }
    }

    private void initUserResult() {
        user.initBridgeForGame();
    }

    private boolean moveOverBridge() {
        int round = 0 ;
        while (bridgeLength != round) {
            outputController.printMoveInfoMessage();
            String moveCommand = inputController.readNextMove();
            if(!move(moveCommand,round)) return false;
            round++;
        }
        user.clearGame();
        return true;
    }

    private boolean move(String moveCommand,int round) {
        boolean canGo = user.matchBridge(moveCommand,answerBridge,round);
        outputController.printUserBridge(user);
        return  canGo;
    }

    private String retry() {
        outputController.printRestartInputInfoMessage();
        return inputController.readGameCommand();
    }
    public void showGameResult() {
        outputController.printResult(user);
    }
}
