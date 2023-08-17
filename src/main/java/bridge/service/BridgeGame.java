package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.UserBridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private List<String> answerBridge = new ArrayList<>();

    private final UserBridge userBridge = new UserBridge();
    private int ground = 0;

    public void createBridge(int size) {
        answerBridge = bridgeMaker.makeBridge(size);
    }

    public Boolean checkMove(String direction) {
        return answerBridge.get(ground).equals(direction);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Boolean move(String direction) {
        // 건널수있는지 확인
        boolean isCorrectMove = checkMove(direction);
        userBridge.update(direction, isCorrectMove);
        if (isCorrectMove) {
            ground++;
        }
        return isCorrectMove;
    }

    public boolean isComplete() {
        return ground == answerBridge.size();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        userBridge.initUserBridge();
        ground = 0;
    }
    public UserBridge getUserBridge() {
        return userBridge;
    }

}
