package progremmers.level1;

public class Test {
    public static void main(String[] args) {
//        System.out.println("args = " +solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
        System.out.println("args = " + solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println("args = " + solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }

    public static int solution(int[] ingredient) {
        // 빵 - 야채 - 고기 - 빵  | 1 2개 , 2 1개 , 3 1개
        StringBuilder stack = new StringBuilder();
        int count = 0;

        for (int i : ingredient) {
            stack.append(i);

            if (stack.length() >= 4 &&
                    stack.substring(stack.length() - 4).equals("1231")) {
                stack.setLength(stack.length() - 4);
                count++;
            }
        }

        return count;
    }
}
