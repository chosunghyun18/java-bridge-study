package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.  system 전달 전 모든 예외처리를 진행 한다.
 */
public class InputView {
    public int readBridgeSize() {
        String input =  Console.readLine();
        if( input.length() > 2 ) throw new IllegalArgumentException("[Eroor] over size");
        return convertSingleInt(input);
    }

    private int convertSingleInt(String input) {
        try {
            int givenInt = Integer.parseInt(input);
            if( givenInt > 20) throw new IllegalArgumentException("[Eroor] over 20");
            if( givenInt < 3 ) throw new IllegalArgumentException("[Eroor] under 3");
            return givenInt ;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[Eroor] : not number");
        }
    }

    public String readMoving() {
        List<String> canRead = new ArrayList<>(Arrays.asList("U","D"));
        String input =  Console.readLine();
        if(input.length() != 1) throw new IllegalArgumentException("[Eroor] over size");
        if(canRead.contains(input)) return input;
        if(!canRead.contains(input))throw new IllegalArgumentException("[Eroor] wrong move");
        return input;
    }


    public String readGameCommand() {
        List<Character> canRead = new ArrayList<>(Arrays.asList('R','Q'));
        String input =  Console.readLine();
        if(input.length() != 1) throw new IllegalArgumentException("[Eroor] over size");
        if(canRead.contains(input)) return input;
        if(!canRead.contains(input))throw new IllegalArgumentException("[Eroor] wrong move");
        return input;
    }
}
