package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerInfo {
    private List<Boolean> playerAnswer;
    private int tryNumber;
    private List<List<String>> answerMap;

    public PlayerInfo(){
        this.playerAnswer = new ArrayList<>();
        this.tryNumber = 0;
        this.answerMap = initMap();
    }

    //재시작을 위한 준비 (정답 초기화, try 횟수 증가)
    public void prepareRetry() {
        playerAnswer.clear();
        answerMap.clear();
        tryNumber++;
    }

    //마지막 라운드인지 확인
    public boolean isLastRoundEnd(List<String> answerBridge) {
        return (answerBridge.size() == playerAnswer.size());
    }

    //정답인지 아닌지 판별, 값 설정
    public boolean isAnswer(String position, List<String> answerBridge) {
        int size = playerAnswer.size();
        if(position.equals(answerBridge.get(size))){
            playerAnswer.add(true);
            addAnswerMap(position, "0");
            return true;
        }else{
            playerAnswer.add(false);
            addAnswerMap(position, "X");
            return false;
        }
    }

    public List<Boolean> getPlayerAnswer(){
        return playerAnswer;
    }

    public int getTryNumber(){
        return tryNumber;
    }

    public List<List<String>> getAnswerMap() {
        return answerMap;
    }

    public List<List<String>> initMap(){
        List<List<String>> answerMap = new ArrayList<>();
        for(int i=0; i<2; i++){
            List<String> row = new ArrayList<>();
            answerMap.add(row);
        }
        return answerMap;
    }

    private void addAnswerMap(String position, String answer) {
        if(position.equals("U")){
            answerMap.get(0).add(answer);
            answerMap.get(1).add(" ");
        }else{
            answerMap.get(0).add(" ");
            answerMap.get(1).add(answer);
        }
    }
}
