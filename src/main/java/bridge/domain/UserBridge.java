package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class UserBridge {
   private final List<String> upBridge;
   private final List<String> downBridge;

   public UserBridge() {
      this.upBridge = new ArrayList<>();
      this.downBridge = new ArrayList<>();
   }

   public void update(String direction, boolean isCorrect) {
      if (direction.equals("U")){
         if (isCorrect) {
            upBridge.add("O");
            downBridge.add(" ");
         } else {
            upBridge.add("X");
            downBridge.add(" ");
         }
      }
      if (direction.equals("D")){
         if (isCorrect) {
            downBridge.add("O");
            upBridge.add(" ");
         } else {
            downBridge.add("X");
            upBridge.add(" ");
         }
      }
   }

   public void initUserBridge() {
      upBridge.clear();
      downBridge.clear();
   }

   public List<String> getDownBridge() {
      return downBridge;
   }

   public List<String> getUpBridge() {
      return upBridge;
   }
}
