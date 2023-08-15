package bridge.view;

import bridge.UserResult.UserResultTest;
import bridge.domain.UserResult;

import bridge.dto.ResponseUserBridgeDto;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    UserResult userResult = new UserResultTest();
    OutputView outputView = new OutputView() ;
    @Test
    void printMap_Test() {
        ResponseUserBridgeDto responseMapDto = new ResponseUserBridgeDto(userResult);
        outputView.printMap(responseMapDto);
    }

}