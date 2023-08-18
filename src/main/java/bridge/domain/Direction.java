package bridge.domain;

public enum Direction {
   UP(1, "U"),
   DOWN(0, "D");

   private final int idx;
   private final String label;

   Direction(int idx, String label) {
      this.idx = idx;
      this.label = label;
   }

   // 0, 1 -> U, D
   public static String findLabel(int idx) {
      for(Direction direction: Direction.values()) {
         if (direction.idx == idx) {
            return direction.label;
         }
      }
      throw new IllegalArgumentException();
   }

   public boolean isEqual(String label) {
      return this.label.equals(label);
   }
}
