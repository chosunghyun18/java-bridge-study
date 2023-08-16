package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import bridge.model.Footprint;
import bridge.model.Player;

import java.util.ArrayList;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static int INITIALIZE_PLAYER_LOCATION = 0;
    private BridgeMaker bridgeMaker;

    public BridgeGame() {
    }

    private Bridge bridgeInit() {
        // bridge size alarm required
        int bridgeSize = 9;// bridge size input required
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public void gameStart() {
        // game start alarm required
        Bridge bridge = bridgeInit();
        Player player = new Player(new Footprint(new ArrayList<>()), INITIALIZE_PLAYER_LOCATION);
        player.initializeTryTime();
        inGame(bridge, player);
    }

    private void inGame(Bridge bridge, Player player) {
        player.intializeData();
        while (true) {
            //movement alarm required
            String movement = "U";// input method required
            move(movement, bridge, player);
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
        if(player.getFootprint().isEnd()){
            retry(bridge, player);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Bridge bridge, Player player) {
        // retry alarm required
        String answer = "Q";// retry input required
        if (answer.equals("R")) {
            inGame(bridge, player);
        }
    }

}