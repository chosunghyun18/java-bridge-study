package bridge.controller;

import bridge.view.InputView;

public class InputController {
    private final InputView inputView;
    private final OutputController outputController;
    public InputController() {
        this.outputController = new OutputController();
        this.inputView  =  new InputView();
    }
    public int readBridgeSize() {
        try {
            return inputView.readBridgeSize();
        }catch (IllegalArgumentException e){
            System.out.println(e);
            outputController.printBridgeSizeInfoMessage();
            return readBridgeSize();
        }
    }

    public String readMoving() {
        try{
            return inputView.readMoving();
        }catch (IllegalArgumentException e) {
            System.out.println(e);
            outputController.printMoveInfoMessage();
        return readMoving();
        }
    }


    public String readGameCommand() {
        try{
            return inputView.readGameCommand();
        }catch (IllegalArgumentException e) {
            System.out.println(e);
            outputController.printRestartInputInfoMessage();
            return readGameCommand();
        }
    }

}
