package functioninterface;

import java.util.function.Function;
import java.util.function.Predicate;

public class Func {
    public static void main(String[] args) {
        predicate();
       functionTR();
    }
    private static void predicate(){
        Predicate<Integer> isPos1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer>100;
            }
        };
        Predicate<Integer> isPos2 = integer -> integer>100;

    }
    private static void functionTR(){
        Function<String,?> strFunction = new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                return null;
            }
        };

        Function<Integer,?> intFunction = new Function<Integer, Object>() {
            @Override
            public Object apply(Integer i) {
                return null;
            }
        };

        Function<String,Integer> parseInt1 = new Function<String,Integer>() {
            @Override
            public Integer apply(String i) {
                return Integer.parseInt(i);
            }
        };
        Function<String,Integer> parseInt2 = i -> Integer.parseInt(i);
    }
}
