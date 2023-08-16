package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import bridge.model.Footprint;
import bridge.model.Player;
import bridge.view.InputView;

import java.util.ArrayList;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static int INITIALIZE_PLAYER_LOCATION = 0;
    private BridgeMaker bridgeMaker;
    private InputView input;

    public BridgeGame() {
    }

    private Bridge bridgeInit() {
        // bridge size alarm required
        int bridgeSize = input.readBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public void gameStart() {
        // game start alarm required
        Player player = new Player(new Footprint(new ArrayList<>()), INITIALIZE_PLAYER_LOCATION);
        player.initializeTryTime();
        Bridge bridge = bridgeInit();

        inGame(bridge, player);
        result(bridge, player);
    }

    private void inGame(Bridge bridge, Player player) {
        player.intializeData();
        while (true) {
            //movement alarm required
            String movement = input.readMoving();
            move(movement, bridge, player);
            if(player.getFootprint().isEnd()){
                retry(bridge, player);
            }
            break;
        }
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String movement, Bridge bridge, Player player) {
        boolean isCorrect = bridge.isMovementCorrect(movement, player.getLocation());
        player.getFootprint().makeNewFootprint(isCorrect);
        player.moveForword();
        // footprint print required

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Bridge bridge, Player player) {
        // retry alarm required
        String answer = input.readGameCommand();
        if (answer.equals("R")) {
            player.retryTimeUp();
            inGame(bridge, player);
        }
    }

    public void result(Bridge bridge, Player player) {
        // total game result alarm required
        // game result array view required
        // whether the game success or fails view required
        // total retry time view required
    }

}