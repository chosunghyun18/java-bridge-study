package bridge.view;

import static org.junit.jupiter.api.Assertions.*;

import bridge.UserResult.UserResultTest;
import bridge.domain.UserResult;
import bridge.dto.ResponseMapDto;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    UserResult userResult = new UserResultTest();
    OutputView outputView = new OutputView() ;
    @Test
    void printMap_Test() {
        ResponseMapDto responseMapDto = new ResponseMapDto(userResult);
        outputView.printMap(responseMapDto);
    }

}