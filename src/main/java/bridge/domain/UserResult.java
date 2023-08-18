package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class UserResult {

    private List<String> upBridge;
    private List<String> downBridge;
    private String gameClear;
    private int totalGameTry;

    public UserResult() {
        this.gameClear = "실패";
        this.totalGameTry = 0;
    }

    public boolean moveNextStep(String moveCommand, String nextAnswerStep) {
        if (userCanMoveNextStep(moveCommand,nextAnswerStep)) {
            checkCanGo(moveCommand);
            return true;
        }
        checkWrongMove(moveCommand);
        return false;
    }
    private boolean userCanMoveNextStep(String moveCommand, String nextAnswerStep) {
        return moveCommand.equals(nextAnswerStep);
    }
    private void checkCanGo(String command) {
        if (command.equals("U")) {
            upBridge.add(" O ");
            downBridge.add("   ");
        }
        if (command.equals("D")) {
            upBridge.add("   ");
            downBridge.add(" O ");
        }
    }

    private void checkWrongMove(String command) {
        if (command.equals("U")) {
            upBridge.add(" X ");
            downBridge.add("   ");
        }
        if (command.equals("D")) {
            upBridge.add("   ");
            downBridge.add(" X ");
        }
    }

    public boolean isCrossBridge(int bridgeSizeToCross) {
        if (upBridge.size() == bridgeSizeToCross) {
            gameClear = "성공";
            return false;
        }
        return true;
    }

    public void initBridgeForGame() {
        this.upBridge = new ArrayList<>();
        this.downBridge = new ArrayList<>();
        totalGameTry++;
    }

    public String getGameClearForResponse() {
        return gameClear;
    }

    public int getGameTryForResponse() {
        return totalGameTry;
    }

    public List<String> getUpBridgeForResponse() {
        return upBridge;
    }

    public List<String> getDownBridgeForResponse() {
        return downBridge;
    }
}
