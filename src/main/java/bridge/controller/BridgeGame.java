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
    private UserResult userResult;
    private List<String> answerBridge ;
    private int bridgeSize;
    private final OutputController outputController;
    private final InputController inputController;
    private BridgeGame() {
        outputController = new OutputController();
        answerBridge = new ArrayList<>();
        inputController = new InputController();
        userResult = new UserResult();
        outputController.printStartInfoMessage();
        makeBridge();
    }
    public static BridgeGame startGame(){
        return new BridgeGame();
    }

    private void makeBridge() {
        bridgeSize = inputController.readBridgeSize();
        BridgeNumberGenerator numberGenerator = new NumberGenerator(bridgeSize);
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        answerBridge = bridgeMaker.makeBridge(bridgeSize);
    }
    public void processGame() {
        String retryStaus = "R";
        while (retryStaus.equals("R")) {
            userResult.tryGamePlay();
            boolean clearStage = moveOverBridge();
            if(clearStage) retryStaus = "Q";
            if(!clearStage) {
                retryStaus = retry();
            }
        }
    }

    private boolean moveOverBridge() {
        int inputCount = 0 ;
        while (bridgeSize != inputCount) {
            String moveCommand = inputController.readMoving();
            if(!move(moveCommand,inputCount)) return false;
        }
        userResult.clearGame();
        return true;
    }

    private boolean move(String moveCommand,int inputConut) {
        return userResult.matchBridge(moveCommand,answerBridge,inputConut);
    }

    private String retry() {
        return inputController.readGameCommand();
    }
    public void showResult() {
        outputController.printResult(userResult);
    }
}
