package bridge.dto;

import bridge.domain.UserResult;

public class ResponseResultDto {
    private final String userGameClear;
    private final int userGameTry;
    public ResponseResultDto(UserResult userResult){
        this.userGameClear =userResult.getGameClear();
        this.userGameTry = userResult.getGameTry();
    }

    public String getUserGameClear() {
        return userGameClear;
    }

    public int getUserGameTry() {
        return userGameTry;
    }
}
