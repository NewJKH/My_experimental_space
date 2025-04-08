package progremmers.level0;

import java.util.Arrays;

public class ArraySum {

    public int[] test(int n, int[] numlist){
        return Arrays.stream(numlist)
                .filter(num -> num % n == 0)
                .toArray();
    }
}
