package progremmers.level2.파보나치.재귀;

public class Fabo {
    public static void main(String[] args) {
        int n = 5;
        fabo(n);
    }
    private static int fabo(int n){
        if ( n == 0 ) return 0;
        if ( n == 1 ) return 1;
        return fabo(n-1)+fabo(n-2);
    }
}
