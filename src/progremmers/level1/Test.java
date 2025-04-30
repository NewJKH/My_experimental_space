package progremmers.level1;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public double solution(int[] arr) {
        AtomicInteger sum = new AtomicInteger();

        Arrays.stream(arr)
                .forEach(sum::addAndGet);

        return (double) sum.get() / arr.length;
    }
}
