package bridge.controller;

import bridge.view.OutputView;

public class OutputController {
    private final OutputView outputView;

    public OutputController(){
        this.outputView = new OutputView();
    }

    public void printStartMessageController(){
        outputView.printStartMessage();
    }





}
