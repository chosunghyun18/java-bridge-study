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

   public void update(String direction, boolean isSuccess) {
      if (direction.equals("U")){
         addUpBridge(isSuccess);
      }
      if (direction.equals("D")){
         addDownBridge(isSuccess);
      }
   }

   private void addUpBridge(boolean isSuccess) {
      if (isSuccess) {
         upBridge.add("O");
      }
      if (!isSuccess) {
         upBridge.add("X");
      }
      downBridge.add(" ");
   }

   private void addDownBridge(boolean isSuccess) {
      if (isSuccess) {
         downBridge.add("O");
      }
      if (!isSuccess) {
         downBridge.add("X");
      }
      upBridge.add(" ");
   }

   public void initUserBridge() {
      upBridge.clear();
      downBridge.clear();
   }

   public boolean isWin() {
      return !upBridge.contains("X") && !downBridge.contains("X");
   }

   public List<String> getDownBridge() {
      return downBridge;
   }

   public List<String> getUpBridge() {
      return upBridge;
   }
}
