package bridge.view;

import bridge.domain.UserBridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printStartGameMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    public void printRetryOrExit() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(UserBridge userBridge) {
        printSingleMap(userBridge.getUpBridge());
        printSingleMap(userBridge.getDownBridge());
        System.out.println();
    }

    private void printSingleMap(List<String> bridge) {
        System.out.print("[ ");
        for (int i = 0; i < bridge.size(); i++) {
            System.out.print(bridge.get(i));
            if (i != bridge.size() - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(UserBridge userBridge, int attempts) {
        System.out.println("최종 게임 결과");
        printMap(userBridge);
        boolean isSuccess = !userBridge.getUpBridge().contains("X") && !userBridge.getDownBridge().contains("X");
        System.out.println("게임 성공 여부: " + (isSuccess ? "성공" : "실패"));
        System.out.println("총 시도한 횟수: " + attempts);
//        System.out.println("총 시도한 횟수: " + userBridge.getCount());
    }
}
