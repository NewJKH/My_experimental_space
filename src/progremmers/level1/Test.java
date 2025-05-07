package progremmers.level1;

public class Test {
    public static void main(String[] args) {
        System.out.println(" 값1 : "+ solution("abcde"));
        System.out.println(" 값2 : "+ solution("qwer"));
    }

    public static String solution(String s) {
        int size = s.length();
        int a = size/2;
        boolean stat = size % 2 == 0;

        return stat ? s.substring(a-1,a+1) : s.substring(a,a+1);
    }
}
