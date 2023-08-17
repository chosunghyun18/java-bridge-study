package bridge.validate;

public class Validate {
    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 20;

    //정수가 맞는지 확인
    public static int parseInt(String input){
        try{
            return Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("정수가 아님");
        }
    }

    //3~20 사이의 숫자인지 확인
    public static int checkNumberRange(int size){
        if(size<3 || size>20){
            throw new IllegalArgumentException("3~20 사이의 정수가 아님");
        }
        return size;
    }

}
