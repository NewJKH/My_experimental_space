package progremmers.level1.약수;

public class 약수 {
    public static void main(String[] args) {
        int n = 1000000;
        long start;
        long end;

        start = System.nanoTime();
        일반(n);
        end = System.nanoTime();
        System.out.println("일반 처리 시간: " + (end - start) / 1_000_000.0 + " ms\n");

        start = System.nanoTime();
        나누기(n);
        end = System.nanoTime();
        System.out.println("절반 처리 시간: " + (end - start) / 1_000_000.0 + " ms\n");

        start = System.nanoTime();
        라이브러리(n);
        end = System.nanoTime();
        System.out.println("라이브러리 처리 시간: " + (end - start) / 1_000_000.0 + " ms\n");

        start = System.nanoTime();
        제곱근(n);
        end = System.nanoTime();
        System.out.println("제곱 처리 시간: " + (end - start) / 1_000_000.0 + " ms\n");

    }
    private static void 일반(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) sum += i;
        }
        System.out.println("일반: "+sum);
    }
    private static void 나누기(int n){
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) sum += i;
        }
        sum += n;
        System.out.println("절반: "+sum);
    }
    private static void 제곱근(int n){
        int sum = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) sum += n / i;
            }
        }
        System.out.println("제곱근: "+sum);
    }
    private static void 라이브러리(int n){
        int sum = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) sum += n / i;
            }
        }
        System.out.println("라이브: "+sum);
    }
}
