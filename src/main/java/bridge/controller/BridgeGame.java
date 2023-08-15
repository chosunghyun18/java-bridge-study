package bridge.controller;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;

import bridge.domain.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge ;
    private int bridgeSize;
    private final OutputController outputController;
    private final InputController inputController;
    private BridgeGame() {
        outputController = new OutputController();
        bridge = new ArrayList<>();
        inputController = new InputController();
        outputController.printStartInfoMessage();
        makeBridge();
    }
    public static BridgeGame startGame(){
        return new BridgeGame();
    }

    public List<String> getBridge() {
        return bridge;
    }

    private void makeBridge() {
        bridgeSize = inputController.readBridgeSize();
        BridgeNumberGenerator numberGenerator = new NumberGenerator(bridgeSize);
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
