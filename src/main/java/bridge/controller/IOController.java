package bridge.controller;

import bridge.exception.InputValidation;
import bridge.model.Bridge;
import bridge.model.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class IOController {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private final InputView inputView;
    private final OutputView outputView;

    public IOController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void printError(String error) {
        System.out.println(ERROR_MESSAGE+ error);
    }

    public int bridgeSizeIn() {
        System.out.println(outputView.bridgeSizeNotificate());
        try {
            int bridgeSize = InputValidation.isNumeric(inputView.readBridgeSize());
            InputValidation.isNaturalNumber(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return bridgeSizeIn();
        }
    }

    public String readMovement() {
        System.out.println(outputView.movementNotificate());
        try {
            String movement = inputView.readMoving();
            InputValidation.checkMovementValid(movement);
            return movement;
        } catch (IllegalArgumentException e) {
            printError(ERROR_MESSAGE + e.getMessage());
            return readMovement();
        }
    }

    public void gameStartNotificate() {
        System.out.println(outputView.gameStartNotificate());
    }

    public void printCurrentMap(Player player, Bridge bridge) {
        outputView.printMap(player.getFootprint(), bridge);
    }

    public void retryNotificate(Player player, Bridge bridge) {
        outputView.printResult(bridge, player);
        outputView.retryNotificate();
    }

    public void resultNotificate(Bridge bridge, Player player) {
        outputView.printResult(bridge, player);
    }

    public String readCommand() {
        try {
            String input = inputView.readGameCommand();
            InputValidation.checkRestartMethodValid(input);
            return input;
        } catch (IllegalArgumentException e) {
            printError(ERROR_MESSAGE + e.getMessage());
            return readCommand();
        }
    }



}
