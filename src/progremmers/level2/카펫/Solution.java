package progremmers.level2.카펫;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] solution(int brown, int yellow) {

        List<Tuple<Integer,Integer>> list = divisors(brown+yellow);
        for (Tuple<Integer, Integer> tuple : list) {
            int x = tuple.getX();
            int y = tuple.getY();

            int inner = (x - 2) * (y - 2);
            if (inner == yellow) {
                return new int[]{x, y};
            }
        }
        return new int[0];
    }

    private List<Tuple<Integer,Integer>> divisors(int n){
        List<Tuple<Integer,Integer>> list = new ArrayList<>();

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                int x = n/i;
                int y = i;
                if ( x < y ) break;
                list.add(new Tuple<>(x,y));
            }
        }
        return list;
    }

    private class Tuple<X,Y>{
        private int x;
        private int y;

        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
