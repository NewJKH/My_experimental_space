package progremmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectOrange {

    public static void main(String[] args) {
        int k = 4;
        int[] v1 = new int[]{1, 3, 2, 5, 4, 5, 2, 3};
        int[] v2 = new int[]{1, 3, 2, 5, 4, 5, 2, 3};
        int[] v3 = new int[]{1, 1, 1, 1, 2, 2, 2, 3};

        /*
            k 개를 구매하고 싶다면 v 에서 3개를 골라 판매
            여기서 종류 별로 고른게 최솟값

            # Greedy 알고리즘 선택
         */
        /*
        일단 Map 을 사용해서 크기별로 몇개가 있는지 나열
         */
        Map<Integer, Integer> box = groupBySize(v2); // 크기별로 정리된 box
        int buy = minTypesToBuy(k,box);// k 와 박스를 보내줌 - 목적은 그리디 알고리즘을 사용해서 최적의 수를 구하는 메서드
        System.out.println(buy);
    }

    private static int minTypesToBuy(int k, Map<Integer, Integer> box) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(box.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        int min = 0;
        int ck = k;

        for (Map.Entry<Integer, Integer> entry : list) {
            if ( ck > 0 ) {
                ck -= entry.getValue();
                min++;
            }
        }

        return min;
    }

    private static Map<Integer, Integer> groupBySize(int[] v) {
        Map<Integer, Integer> box = new HashMap<>();

        for (int i : v) {
            box.put(i, box.getOrDefault(i, 0) + 1);
        }

        return box;
    }

}
