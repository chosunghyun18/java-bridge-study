package bridge.validate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidate {

    public int convertSingleInt(String input) {
        try {
            int givenInt = Integer.parseInt(input);
            if (givenInt > 20) throw new IllegalArgumentException("over 20");
            if (givenInt < 3) throw new IllegalArgumentException("under 3");
            return givenInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("not number");
        }
    }

    public void sizeInputCheckForBridgeSize(String input) {
        if (input.length() > 2) {
            throw new IllegalArgumentException("over size");
        }
    }

    public void readMovingCheck(String move) {
        List<String> canRead = new ArrayList<>(Arrays.asList("U", "D"));
        lengthAndContainCommandCheck(move, canRead);
    }

    public void readGameRestartCommand(String command) {
        List<String> canRead = new ArrayList<>(Arrays.asList("R", "Q"));
        lengthAndContainCommandCheck(command, canRead);
    }

    private void lengthAndContainCommandCheck(String command, List<String> accept) {
        if (command.length() != 1) {
            throw new IllegalArgumentException("over size");
        }
        if (!accept.contains(command)) {
            throw new IllegalArgumentException("wrong move");
        }
    }

}
