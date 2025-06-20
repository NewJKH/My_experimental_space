package progremmers.level1.약수;

public class 약수카운트 {
    public static void main(String[] args) {
        System.out.println(" 갯수1 : "+solution(5,3,2));
        System.out.println(" 갯수2 : "+solution(10,3,2));
    }
    public static int solution(int number, int limit, int power) {
        int answer = 0;
        for ( int i = 1; i <= number; i++ ){
            int count = 약수_갯수(i);
            System.out.print(" "+count);
            if ( limit < count ){
                count = power;
            }
            answer+=count;
        }
        return answer;
    }
    private static int 약수_갯수(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (i * i == num) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
}
