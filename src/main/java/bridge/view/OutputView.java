package bridge.view;

import bridge.model.Bridge;
import bridge.model.Footprint;
import bridge.model.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public OutputView() {
    }

    public void gameStartNotificate() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void bridgeSizeInputNotifivcate() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void movementNotificate() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void retryNotificate() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Footprint footprint, Bridge bridge) {
        ArrayList<String> wrappedModel = wrapModel(makeModel(footprint, bridge));
        for (String line : wrappedModel) {
            System.out.println(line);
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Bridge bridge, Player player) {
        System.out.println("최종 게임 결과");
        printMap(player.getFootprint(), bridge);
        System.out.println();
        System.out.println("게임 성공 여부: "+ player.getIsSuccess());
        System.out.println("총 시도한 횟수: " + player.getRetryTime());
    }
    private ArrayList<String> makeModel(Footprint footprint, Bridge bridge) {
        StringBuilder firstLine = new StringBuilder();
        StringBuilder secondLine = new StringBuilder();
        for (int i = 0; i < footprint.getFootprint().size(); i++) {
            List<String> modelLines = modelAddLine(footprint.getFootprint().get(i), bridge.getBridge().get(i));
            firstLine.append(modelLines.get(0));
            secondLine.append(modelLines.get(1));
        }
        return new ArrayList<>(Arrays.asList(firstLine.toString(), secondLine.toString()));
    }

    /**
     *
     * @param oOrX Bridge의 OX
     * @param uOrD 사용자의 U D
     * @return
     */
    private ArrayList<String> modelAddLine(String oOrX, String uOrD) {
        String firstLine = " ";
        String secondLine = " ";

        if (upX(oOrX, uOrD) || downO(oOrX, uOrD)) {
            secondLine = oOrX;
        } else {
            firstLine = oOrX;
        }

        return new ArrayList<>(Arrays.asList(firstLine, secondLine));
    }

    private boolean upX(String oOrX, String uOrD){
        return uOrD.equals("U") && oOrX.equals("X");
    }
    private boolean downO(String oOrX, String uOrD){
        return uOrD.equals("D") && oOrX.equals("O");
    }


    private ArrayList<String> wrapModel(ArrayList<String> model) {
        ArrayList<String> wrappedModel = new ArrayList<>();
        for (String line : model) {
            line = insertPipes(line);
            line = "[ " + line + " ]";
            wrappedModel.add(line);
        }
        return wrappedModel;
    }

    private static String insertPipes(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length() - 1; i++) {
            sb.append(input.charAt(i));
            sb.append(" | ");
        }
        sb.append(input.charAt(input.length() - 1));

        return sb.toString();
    }


}
