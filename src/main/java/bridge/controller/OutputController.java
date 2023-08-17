package bridge.controller;

import bridge.view.OutputView;

import java.util.List;

public class OutputController {
    private final OutputView outputView;

    public OutputController(){
        this.outputView = new OutputView();
    }

    public void printStartMessageController(){
        outputView.printStartMessage();
    }

    public void printMapController(List<List<String>> answerMap){
        outputView.printMap(answerMap);
    }

    public void printResultController(List<List<String>> answerMap, boolean success, int tryNumber){
        String successString = "실패";
        if(success)
            successString = "성공";
        outputView.printResult(answerMap, successString, tryNumber);
    }

}
