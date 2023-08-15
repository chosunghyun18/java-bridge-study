package bridge.controller;

import bridge.validate.InputValidate;
import bridge.view.InputView;
import bridge.view.OutputView;

public class ViewController {
    private InputView inputView;
    private OutputView outputView;
    private InputValidate inputValidate;

    public ViewController() {
        this.inputView = new InputView();
        this.outputView  =  new OutputView() ;
        this.inputValidate = new InputValidate();
    }
}
