package functioninterface;

import domain.Student;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Func {
    public static void main(String[] args) {
        predicate();
        supplier();
       functionTR();
       comparator();
       runnable();
       callback();
    }

    private static void callback() {
        Callable<Student> callable = new Callable<>() {
            @Override
            public Student call() throws Exception {
                return new Student(1, "테스트", 10, "F");
            }
        };
        try {
            Student student = callable.call();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void runnable() {
        Runnable runnable = Func::comparator;
        runnable.run();
    }

    private static void comparator() {
        Comparator<Integer> compare = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1)+Integer.parseInt(o2);
            }
        };
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
    private static void supplier(){
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "TEST";
            }
        };
        Supplier<String> supplier1 = () -> "TEST";
        supplier.get();
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
