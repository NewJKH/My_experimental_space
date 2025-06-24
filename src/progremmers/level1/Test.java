package progremmers.level1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        System.out.println("args = " + Arrays.toString(solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
        System.out.println("args = " + Arrays.toString(solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"})));
    }

    public static int[] solution(String today, String[] terms, String[] pri) {
        Map<Character, Integer> times = new HashMap<>();
        for ( String t : terms ){
            char rank = t.charAt(0);
            String month = t.substring(2);
            times.put(rank, Integer.valueOf(month));
        }
        List<Integer> list = new ArrayList<>();
        LocalDate now = formatTime(today);

        for ( int i = 0 ; i< pri.length;i++ ){
            char rank = pri[i].charAt(11);
            int month = times.get(rank);

            String date = pri[i].substring(0,10);
            LocalDate localDate = formatTime(date);
            LocalDate newDate = localDate.plusMonths(month);
            if ( newDate.isBefore(now) || newDate.isEqual(now) ){
                list.add(i+1);
            }

        }
        int[] answer = new int[list.size()];
        for ( int n = 0; n<list.size(); n++ ){
            answer[n] = list.get(n);
        }
        return answer;
    }
    private static LocalDate formatTime(String date){
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    }
}
