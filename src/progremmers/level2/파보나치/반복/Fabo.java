package progremmers.level2.파보나치.반복;

public class Fabo {
    public static void main(String[] args) {
        fabo(5);
    }
    private static int fabo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0;
        int b = 1;

        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }
}
