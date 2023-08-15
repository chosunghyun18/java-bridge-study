package bridge.view;

import bridge.validate.InputValidate;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.  system 전달 전 모든 예외처리를 진행 한다.
 */
public class InputView {

    private final InputValidate inputValidate;

    public InputView() {
        inputValidate = new InputValidate();
    }

    public int readBridgeSize() {
        String input = Console.readLine();
        inputValidate.sizeInputCheckForBridgeSize(input);
        return inputValidate.convertSingleInt(input);
    }

    public String readMoving() {
        String input = Console.readLine();
        inputValidate.readMovingCheck(input);
        return input;
    }

    public String readGameCommand() {
        String input = Console.readLine();
        inputValidate.readGameRestartCommand(input);
        return input;
    }
}
