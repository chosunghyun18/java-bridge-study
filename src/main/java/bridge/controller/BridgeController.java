package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 게임 진행
 * 1. 게임 시작 메세지
 * 2. 다리 길이 입력 -> 입력값 검사
 * 3. 입력값으로 다리 만들기 makeBridge: for문 돌면 0 입력 받으면 아래칸에 D, 1입력받으면 윗칸에 U
 * 4.
 */
public class BridgeController {
   private final BridgeGame bridgeGame = new BridgeGame();
   private final InputView inputView = new InputView();
   private final OutputView outputView = new OutputView();
   private int attemps = 1;

   public void run() {
      try {
         start();
      } catch (IllegalArgumentException e) {
         System.out.println(e);
      }
   }

   public void start() {
      // 시작메세지
      outputView.printStartGameMessage();
      // 다리길이 입력받아서 다리 만들기
      bridgeGame.createBridge(inputView.readBridgeSize());
      // 이동할칸 입력받기
      playGame();
   }

   private void playGame() {
      while(!bridgeGame.isComplete()) {
         // 입력받아서 건널수있는지 확인하고 결과도 저장
         String inputValue = inputView.readMoving();
         boolean isCorrectMove = bridgeGame.move(inputValue);
         // 현재 진행상태 출력
         outputView.printMap(bridgeGame.getUserBridge());
         //
         if (!isCorrectMove) {
            outputView.printRetryOrExit();
            String inputCommand = inputView.readGameCommand();
            if (inputCommand.equals("R")){
               bridgeGame.retry();
               attemps++;
            }
            else {
               break;
            }
         }
      }
      outputView.printResult(bridgeGame.getUserBridge(), attemps);
   }
}
