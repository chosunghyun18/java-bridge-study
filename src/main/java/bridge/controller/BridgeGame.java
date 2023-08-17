package bridge.controller;

import bridge.model.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.PlayerInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * <p>
 * InputView, OutputView 사용 불가능 / 필드 추가 가능
 */
public class BridgeGame {
    private List<String> answerBridge;
    private final PlayerInfo playerInfo;
    private final OutputController outputController;
    private final InputController inputController;

    private BridgeGame(){
        this.answerBridge = new ArrayList<>();
        this.playerInfo = new PlayerInfo();
        this.outputController = new OutputController();
        this.inputController = new InputController();

        makeAnswerBridge();
    }

    public static void startGame() {
        new BridgeGame();
    }

    /**
     * 정답 다리 생성하는 메서드
     */
    private void makeAnswerBridge() {
        outputController.printStartMessageController();
        int size = inputController.readBridgeSizeController();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        answerBridge = bridgeMaker.makeBridge(size);
        //move();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        while(true){
            if(playerInfo.isLastRoundEnd(answerBridge)) {
                outputController.printResultController(playerInfo.getAnswerMap(), true, playerInfo.getTryNumber());  //마지막 라운드 끝(최종 결과 출력)
                break;
            }
            String position = inputController.readMovingController();  //U, D 입력
            boolean correct = playerInfo.isAnswer(position, answerBridge);
            outputController.printMapController(playerInfo.getAnswerMap());
            if(!correct){
                String retryOrExit = inputController.readGameCommandController();
                if(retryOrExit.equals("R")){
                    retry();
                    break;
                }else{
                    outputController.printResultController(playerInfo.getAnswerMap(), false, playerInfo.getTryNumber());  //마지막 라운드 끝(최종 결과 출력)
                }
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        playerInfo.prepareRetry();
        move();
    }
}
