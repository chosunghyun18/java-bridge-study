package bridge.view;

import static org.junit.jupiter.api.Assertions.*;

import bridge.UserResult.UserResultTest;
import bridge.domain.UserResult;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    UserResultTest userResult = new UserResultTest();
    OutputView outputView = new OutputView() ;
    @Test
    void printMap_Test() {
        outputView.printMap(userResult.getUpBridge(),userResult.getDownBridge());
    }

}