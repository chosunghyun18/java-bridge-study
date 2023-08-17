package bridge.exception;

public class InputValidation {
    private static final String ERROR_MESSAGE = "[ERROR]";
    public static int isNumeric(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력된 값은 자연수여야 합니다.");
        }
    }

    public static void isNaturalNumber(int input) {
        if (input<0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력된 숫자는"+ "자연수여야 합니다.");
        }
    }

    public static void checkNumberRange(int input) {
        if (!isNumberRangeValid(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력된 숫자는"+ " 2와 20 이내의 숫자여야 합니다.");
        }
    }

    private static boolean isNumberRangeValid(int input) {
        return input <= 20 && input >= 3;
    }

    public static void checkMovementValid(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력된 문자는"+ "U 또는 D여야 합니다.");
        }
    }

    public static void checkRestartMethodValid(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력된 문자는"+ "R 또는 Q여야 합니다.");
        }
    }


}
