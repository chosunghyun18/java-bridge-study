package bridge.validate;

public class Validate {
    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 20;

    //정수가 맞는지 확인
    public static int parseInt(String input){
        try{
            return Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("정수를 입력하시오.");
        }
    }

    //3~20 사이의 숫자인지 확인
    public static int checkNumberRange(int size){
        if(size<3 || size>20){
            throw new IllegalArgumentException("3~20 사이의 정수를 입력하시오.");
        }
        return size;
    }

    //U, D 인지 확인
    public static String checkPosition(String position){
        if(!position.equals("U") && !position.equals("D")){
            throw new IllegalArgumentException("U 또는 D를 입력하시오.");
        }
        return position;
    }

    //R, Q 인지 확인
    public static String checkRetryOrExit(String retryOrExit){
        if(!retryOrExit.equals("R") && !retryOrExit.equals("Q")){
            throw new IllegalArgumentException("R 또는 Q를 입력하시오.");
        }
        return retryOrExit;
    }

}
