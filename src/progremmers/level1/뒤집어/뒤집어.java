package progremmers.level1.뒤집어;


import java.util.ArrayList;
import java.util.List;

public class 뒤집어 {
    public static void main(String[] args) {
        long n = 12345;

        int[] result = cutting(n);

    }

    private static int[] cutting(long l) {
        List<Integer> list = new ArrayList<>();
        while (l > 0) {
            long num = l % 10;
            l /= 10;
            list.add((int) num);
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
