package bridge;

public class Validator {
   public void validateDirection(String inputValue) {
      if (!(inputValue.equals("U") || inputValue.equals("D"))) {
         throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 혹은 D만 가능합니다.");
      }
   }

   public void validateBridgeSize(String inputValue) {
      if (!inputValue.matches("^[0-9]*$")) {
         throw new IllegalArgumentException("[ERROR] 다리의 길이는 숫자만 입력 가능");
      }
      int bridgeSize = Integer.parseInt(inputValue);
      if (bridgeSize < 3 || bridgeSize > 20) {
         throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
      }
   }

   public void validateGameCommand(String inputValue) {
      if (!(inputValue.equals("R") || inputValue.equals("Q"))) {
         throw new IllegalArgumentException("[ERROR] 게임 재시작은 R, 종료는 Q를 입력해주세요.");
      }
   }
}
