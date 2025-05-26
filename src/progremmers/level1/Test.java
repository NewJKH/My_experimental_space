package progremmers.level1;


import java.util.Arrays;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        System.out.println("args = " + Arrays.toString(solution(new int[]{1,1,3,3,0,1,1})));

    }

    public static int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            if (stack.isEmpty() || stack.peek() != i) {
                stack.push(i);
            }
        }

        int[] answer = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            answer[i] = stack.get(i);
        }

        return answer;
    }
}
