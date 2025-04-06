package progremmers.level0;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArraySum {

    public void test(String[] s1, String[] s2){
        int a = s1.length;
        int b = s2.length;

        int sum = a+b;
        Set<String> s3 = new HashSet<>();
        s3.addAll(List.of(s1));
        s3.addAll(List.of(s2));
        s3.size();
    }
}
