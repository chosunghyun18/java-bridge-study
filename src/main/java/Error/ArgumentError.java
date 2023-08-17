package Error;

public class ArgumentError {
    private final String SizeNonDigitErrorString = "다리 길이는 숫자로만 이루어져야합니다.";
    private final String SizeOutOfRangeErrorString = "다리 길이는 3 이상 20 이하여야합니다.";
    private final String InvalidMovingErrorString = "이동할 칸은 U(위) 또는 D(아래) 여야합니다.";
    private final String InvalidGameCommandErrorString = "게임 명령어는 R(재시작) / Q(종료) 중 하나여야합니다.";
    private final String movingRegex = "U|D";
    private final String gameCommandRegex = "R|Q";
    private final String digitRegex = "\\d+";
    private final int SizeLowerRange = 3;
    private final int SizeUpperRange = 20;
    public void sizeCheck(String size) {
        if (!size.matches(digitRegex)) {
            throw new IllegalArgumentException(SizeNonDigitErrorString);
        }
        int intSize = Integer.parseInt(size);
        if (intSize < SizeLowerRange || intSize > SizeUpperRange) {
            throw new IllegalArgumentException(SizeOutOfRangeErrorString);
        }
    }
    public void movingCheck(String moving) {
        if (!moving.matches(movingRegex)) {
            throw new IllegalStateException(InvalidMovingErrorString);
        }
    }

    public void gameCommandCheck(String gameCommand) {
        if (!gameCommand.matches(gameCommandRegex)) {
            throw new IllegalStateException(InvalidGameCommandErrorString);
        }
    }
}
