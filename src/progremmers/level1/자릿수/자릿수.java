package progremmers.level1.자릿수;

public class 자릿수 {
    public static void main(String[] args) {
        int n = 12453;
        long start;
        long end;

        start = System.nanoTime();
        파싱(n);
        end = System.nanoTime();
        System.out.println("일반 처리 시간: " + (end - start) / 1_000_000.0 + " ms\n");

        start = System.nanoTime();
        논파싱(n);
        end = System.nanoTime();
        System.out.println("일반 처리 시간: " + (end - start) / 1_000_000.0 + " ms\n");
    }

    private static void 파싱(int n) {
        String str = String.valueOf(n);
        int sum = 0;

        for (char c : str.toCharArray()) {
            sum += c - '0';
        }
        System.out.println(" 파싱 : "+sum);
    }

    private static void 논파싱(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        System.out.println(" 논파싱 : "+sum);
    }
}
