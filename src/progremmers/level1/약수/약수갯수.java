package progremmers.level1.약수;

public class 약수갯수 {
    public static void main(String[] args) {
        System.out.println("args = " + solution(13,17));
    }
    public static int solution(int left, int right) {
        int answer = 0;
        for ( int i = left ; i <= right; i++){
            if ( 약수_구하기(i) ) answer+=i;
            else answer -=i;
        }
        return answer;
    }
    private static boolean 약수_구하기(int val){
        boolean stat = true;
        for (int i = 1; i * i <= val; i++) {
            if (val % i == 0) {
                stat = !stat;
                if (i != val / i) stat = !stat;
            }
        }
        return stat;
    }
}
