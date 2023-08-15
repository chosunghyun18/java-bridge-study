package bridge.validate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidate {
    private static String ERROR_ME = "[ERROR]";
    public int convertSingleInt(String input) {
        try {
            int givenInt = Integer.parseInt(input);
            if( givenInt > 20) throw new IllegalArgumentException(ERROR_ME +"over 20");
            if( givenInt < 3 ) throw new IllegalArgumentException(ERROR_ME +"under 3");
            return givenInt ;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_ME+": not number");
        }
    }

    public void sizeInputCheckForBridgeSize(String input) {
        if( input.length() > 2 ) throw new IllegalArgumentException( ERROR_ME + "over size");
    }
    public void readMovingCheck(String input) {
        List<String> canRead = new ArrayList<>(Arrays.asList("U","D"));
        lengthAndContainCommandCheck(input,canRead);
    }
    public void readGameRestartCommand(String input) {
        List<String> canRead = new ArrayList<>(Arrays.asList("R","Q"));
        lengthAndContainCommandCheck(input,canRead);
    }
    private void lengthAndContainCommandCheck(String command,List<String> accept){
        if(command.length() != 1) throw new IllegalArgumentException(ERROR_ME+"over size");
        if(!accept.contains(command))throw new IllegalArgumentException(ERROR_ME+"wrong move");
    }

}
