package bridge.UserResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserResultTest{
    private List<String> upBridge;
    private List<String> downBridge;
    private String gameClear ;
    private int gameTry ;
    public UserResultTest() {
        this.upBridge  =  new ArrayList<>(Arrays.asList("   "," X "," O "));
        this.downBridge =new ArrayList<>(Arrays.asList(" O ","   "," O "));
        this.gameClear = "성공";
        this.gameTry = 2 ;
    }

    public String getGameClear() {
        return gameClear;
    }
    public int getGameTry() {
        return gameTry;
    }
    public List<String> getUpBridge() {
        return  upBridge ;
    }
    public List<String> getDownBridge() {
        return downBridge ;
    }
}
