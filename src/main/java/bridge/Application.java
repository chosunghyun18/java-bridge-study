package bridge;

import bridge.controller.Game;
import bridge.view.InputView;

public class Application {

    public static void main(String[] args) {
        Game game = new Game();
        InputView inputView = new InputView();
        try {
            System.out.println(inputView.readBridgeSize());
        }catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
        inputView.readGameCommand();
    }
}
