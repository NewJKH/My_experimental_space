package progremmers.level1.평균;

import java.util.Arrays;

public class 배열평균 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        double s = Arrays.stream(arr).average()
                .getAsDouble();
    }
}
