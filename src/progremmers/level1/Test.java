package progremmers.level1;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        System.out.println("args = " + "");
    }

    public String[] solution(String[] players, String[] callings) {
        Map<String,Integer> map = new HashMap<>();
        // 이름이 아니라 처음부터 이름 자체가 순번으로 저장했다면 어떨까?
        // 이름을 찾는다면 시간초과가 오래 걸린다면 처음부터 이름이 아닌 숫자를 저장해놓고 숫자만 바뀌게 저장

        // 1. 즉시즉시 바뀌게 하지않고 카운팅을 사용해서 푼다면? - 시도 결과 : 순서가 안맞아서 실패
        // 2. 컬렉션의 swap 기능을 사용한다면?

        List<String> list = new ArrayList<>(Arrays.asList(players));
        for (String calling : callings) {
            int index = list.indexOf(calling);
            Collections.swap(list,index-1,index);
        }
        String[] ranks = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ranks[i] = list.get(i);
        }

        return ranks;
    }
}
