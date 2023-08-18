package bridge;

import View.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private final int bridgeSize;
    private final String up = "U";
    private final String down = "D";
    private final List<String> upRight = List.of("O", " ");
    private final List<String> upWrong = List.of("X", " ");
    private final List<String> downRight = List.of(" ", "O");
    private final List<String> downWrong = List.of(" ", "X");
    private final String wrong = "X";
    private final List<String> bridge;
    private List<List<String>> currentBridgeState = new ArrayList<>();

    BridgeGame(int bridgeSize) {
        this.bridgeSize = bridgeSize;
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(String moving) {
        if (moving.equals(up)) {
            if (bridge.get(currentBridgeState.size()).equals(moving)) {
                currentBridgeState.add(upRight);
                return currentBridgeState;
            }
            currentBridgeState.add(upWrong);
            return currentBridgeState;
        }
        if (bridge.get(currentBridgeState.size()).equals(moving)) {
            currentBridgeState.add(downRight);
            return currentBridgeState;
        }
        currentBridgeState.add(downWrong);
        return currentBridgeState;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        currentBridgeState.clear();
    }

    public List<List<String>> gameEnd() {
        return currentBridgeState;
    }

    public Result gameResult() {
        if (currentBridgeState.get(currentBridgeState.size()-1).contains(wrong)) {
            return Result.FAIL;
        }
        return Result.SUCCESS;
    }
}
