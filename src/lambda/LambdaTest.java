package lambda;

import lambda.test1.Concatenator;

public class LambdaTest {
    public static void main(String[] args){
        String a = " 람다를 ";
        String b = " 사용 테스트 ";
        nonLambda(a, b);
        useLambda(a, b);
        methodLambda(a, b);

    }

    private static void nonLambda(String a, String b){
        Concatenator concatenator = new Concatenator() {
            @Override
            public String concat(String a, String b) {
                return a+" (그냥붙이기) "+ b;
            }
        };
        String msg = concatenator.concat(a,b);
        System.out.println(msg);
    }


    private static void useLambda(String a, String b) {
        Concatenator lambdaConcat = (x, y) -> x + " (람다) " + y;
        String msg = lambdaConcat.concat(a, b);
        System.out.println(msg);
    }


    private static void methodLambda(String a, String b) {
        Concatenator methodRef = LambdaTest::combine;
        String msg = methodRef.concat(a, b);
        System.out.println(msg);
    }


    private static String combine(String a, String b){
        return a + " (메서드참조) " + b;
    }
}
