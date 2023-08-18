package bridge.dto;

import bridge.domain.UserResult;
import java.util.List;

public class ResponseUserBridgeDto {
        private final List<String> userUpBridge;
        private final List<String> userDownBridge;

        public ResponseUserBridgeDto(UserResult userResult) {
            this.userUpBridge = userResult.getUpBridgeForResponse();
            this.userDownBridge = userResult.getDownBridgeForResponse();
        }

    public List<String> getUserUpBridge() {
        return userUpBridge;
    }

    public List<String> getUserDownBridge() {
        return userDownBridge;
    }
}
