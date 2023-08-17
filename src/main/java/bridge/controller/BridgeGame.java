package bridge.controller;

import bridge.model.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static int INITIALIZE_PLAYER_LOCATION = 0;
    private final BridgeMaker bridgeMaker;
    private final InputView input;
    private final OutputView output;

    public BridgeGame() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.input = new InputView();
        this.output = new OutputView();
    }

    private Bridge bridgeInit() {
        output.bridgeSizeInputNotifivcate();
        int bridgeSize = input.readBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public void gameStart() {
        output.gameStartNotificate();
        Player player = new Player(new Footprint(new ArrayList<>()), INITIALIZE_PLAYER_LOCATION);
        player.initializeTryTime();
        Bridge bridge = bridgeInit();

        inGame(bridge, player);
    }

    private void inGame(Bridge bridge, Player player) {
        player.intializeData();
        while (true) {
            output.movementNotificate();
            String movement = input.readMoving();
            move(movement, bridge, player);
            if(player.getFootprint().isEnd()){
                retry(bridge, player);
            }
            if(player.getFootprint().done(bridge.getBridge().size())){
                player.success();
                output.printResult(bridge, player);
                break;
            }
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
        output.printMap(player.getFootprint(), bridge);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Bridge bridge, Player player) {
        output.printResult(bridge, player);
        output.retryNotificate();
        String answer = input.readGameCommand();
        if (answer.equals("R")) {
            player.retryTimeUp();
            inGame(bridge, player);
        }
    }

}