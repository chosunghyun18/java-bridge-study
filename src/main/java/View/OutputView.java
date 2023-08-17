package View;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final ListTransformer listTransformer = new ListTransformer();
    private final String mapDelimiter = " | ";
    private final String mapPrefix = "[ ";
    private final String mapSuffix = " ]";
    private final String ErrorInstruction = "[ERROR] ";
    private final String StartInstruction = "다리 건너기 게임을 시작합니다.";
    private final String RestartInstruction = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String SizeInstruction = "다리의 길이를 입력해주세요.";
    private final String MovingInstruction = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String GameEndInstruction = "최종 게임 결과";
    private final String SuccessInstruction = "게임 성공 여부: ";
    private final String TryInstruction = "총 시도한 횟수: ";
    private final String[] resultInstruction = {"성공", "실패"};
    public void printStart() {
        System.out.println(StartInstruction);
        System.out.println();
    }
    public void printSize() {
        System.out.println(SizeInstruction);
    }
    public void printException(Exception e) {
        System.out.println(ErrorInstruction + e.getMessage());
    }
    public void printMoving() {
        System.out.println(MovingInstruction);
    }
    public void printRestart() {
        System.out.println(RestartInstruction);
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> map) {
        List<List<String>> transformedMap = listTransformer.transform(map);
        for (Row row : Row.values()) {
            System.out.println(transformedMap.get(row.ordinal()).stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(mapDelimiter, mapPrefix, mapSuffix)));
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> map, Result result, int tryCount) {
        System.out.println(GameEndInstruction);
        printMap(map);
        System.out.println(SuccessInstruction + resultInstruction[result.ordinal()]);
        System.out.println(TryInstruction + tryCount);
    }
}
