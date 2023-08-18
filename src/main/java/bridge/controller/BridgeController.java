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
   private boolean gameRunning = true;
   private int attempts = 1;

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
      while(isGameEnd()) {
         playGround();
      }
      outputView.printResult(bridgeGame.getUserBridge(), attempts);
   }

   private void playGround() {
      boolean isSuccessMove = bridgeGame.move(inputView.readMoving());
      outputView.printMap(bridgeGame.getUserBridge());
      if (!isSuccessMove) {
         playFailGround();
      }
   }

   private void playFailGround() {
      outputView.printRetryOrExit();
      String commend = inputView.readGameCommand();
      if (commend.equals("R")) {
         bridgeGame.retry();
         attempts++;
      }
      if (commend.equals("Q")) {
         gameRunning = false;
      }
   }

   private boolean isGameEnd() {
      if (bridgeGame.isComplete()) {
         gameRunning = false;
      }
      return gameRunning;
   }
}
