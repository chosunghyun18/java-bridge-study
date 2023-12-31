package bridge.view;

import bridge.dto.ResponseUserBridgeDto;
import bridge.dto.ResponseResultDto;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printStartInfoMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }
    public void printBridgeSizeInfoMessage() {
        System.out.println("다리의 길이를 입력해주세요.\n");
    }
    public void printMoveInfoMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
    public void printRestartInputInfoMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(ResponseUserBridgeDto response) {
        System.out.println(response.getUserUpBridge().toString().replace(", ","|"));
        System.out.println(response.getUserDownBridge().toString().replace(", ","|"));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(ResponseResultDto response) {
        System.out.println("게임 성공 여부: "+response.getUserGameClear());
        System.out.println("총 시도한 횟수: "+response.getUserGameTry());
    }
    public void printResultStartMessage() {
        System.out.println("최종 게임 결과");
    }
}
