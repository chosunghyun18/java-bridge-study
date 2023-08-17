package bridge.controller;

import bridge.view.InputView;

public class InputController {
    private final InputView inputView;

    public InputController(){
        this.inputView = new InputView();
    }

    public int readBridgeSizeController(){
        try{
            return inputView.readBridgeSize();
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] " + e);
            return readBridgeSizeController();
        }
    }
}
