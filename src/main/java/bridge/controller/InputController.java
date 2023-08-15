package bridge.controller;

import bridge.view.InputView;

public class InputController {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private final InputView inputView;
    private final OutputController outputController;

    public InputController() {
        this.inputView = new InputView();
        this.outputController = new OutputController();
    }

    private void printErrorMessage(String e) {
        System.out.println(ERROR_MESSAGE + e);
    }

    public int readBridgeSize() {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            outputController.printBridgeSizeInfoMessage();
            return readBridgeSize();
        }
    }

    public String readMoving() {
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            outputController.printMoveInfoMessage();
            return readMoving();
        }
    }

    public String readGameCommand() {
        try {
            return inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            outputController.printRestartInputInfoMessage();
            return readGameCommand();
        }
    }
}
