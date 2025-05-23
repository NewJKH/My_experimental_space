package progremmers.level2.짝지어;

import java.util.Stack;

public class 짝지어제거 {
    public static void main(String[] args) {
        test("baabaa");
        test("abcddcba");
        System.out.println("test() = " + test("baabaa"));
        System.out.println("test2() = " +test("cdcd"));
        System.out.println("test3() = " + test("abcddcba"));
    }
    private static int test(String s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
