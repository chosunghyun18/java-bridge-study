package bridge.controller;

import bridge.domain.UserResult;

import bridge.view.OutputView;
import java.util.List;

public class OutputController {
    private final OutputView outputView;
    public OutputController() {
        this.outputView  =  new OutputView() ;
    }
    public void printStartInfoMessage() {
        outputView.printStartInfoMessage();
    }
    public void printBridgeSizeInfoMessage() {
        outputView.printBridgeSizeInfoMessage();
    }
    public void printMoveInfoMessage() {
        outputView.printMoveInfoMessage();
    }
    public void printRestartInputInfoMessage() {
        outputView.printRestartInputInfoMessage();
    }

    public void printMap(List<String> up ,List<String> down ) {
        outputView.printMap(up,down);
    }

    public void printResult(UserResult userResult) {
        outputView.printResult(userResult);
    }

}
