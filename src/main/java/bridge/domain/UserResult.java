package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class UserResult {

    private List<String> upBridge;
    private List<String> downBridge;
    private String gameClear;
    private int gameTry;

    public UserResult() {
        this.gameClear = "실패";
        this.gameTry = 0;
    }

    public boolean matchBridge(String command, List<String> answerBridge, int checkIndex) {
        if (command.equals(answerBridge.get(checkIndex))) {
            checkCommandMatch(command);
            return true;
        }
        checkCommandWrong(command) ;
        return false;
    }
    private void  checkCommandMatch(String command) {
        if (command.equals("U")) {
            upBridge.add(" O ");
            downBridge.add("   ");
        }
        if (command.equals("D")) {
            upBridge.add("   ");
            downBridge.add(" O ");
        }
    }
    private void  checkCommandWrong(String command) {
        if (command.equals("U")) {
            upBridge.add(" X ");
            downBridge.add("   ");
        }
        if (command.equals("D")) {
            upBridge.add("   ");
            downBridge.add(" X ");
        }
    }
    public void tryGamePlay() {
        this.upBridge = new ArrayList<>();
        this.downBridge = new ArrayList<>();
        gameTry++;
    }

    public void clearGame() {
        gameClear = "성공";
    }

    public String getGameClear() {
        return gameClear;
    }

    public int getGameTry() {
        return gameTry;
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }
}
