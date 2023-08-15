package bridge.controller;

import bridge.domain.UserResult;

import bridge.dto.ResponseMapDto;
import bridge.dto.ResponseResultDto;
import bridge.view.OutputView;

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

    public void printMap(UserResult userResult) {
        ResponseMapDto response = new ResponseMapDto(userResult);
        outputView.printMap(response);
    }

    public void printResult(UserResult userResult) {
        outputView.printResultStartMessage();
        ResponseResultDto response = new ResponseResultDto(userResult);
        printMap(userResult);
        outputView.printResult(response);
    }

}
