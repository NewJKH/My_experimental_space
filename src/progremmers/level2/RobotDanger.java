package progremmers.level2;

import java.util.*;

public class RobotDanger {
    private int[][] a,b;

    private void test1(){
        a = new int[][]{{3,2}, {6,4}, {4,7}, {1,4}};
        b = new int[][]{{4,2}, {1,3}, {2,4}};
    }

    private void test2(){
        a = new int[][]{{3,2}, {6,4}, {4,7}, {1,4}};
        b = new int[][]{{4,2}, {1,3}, {4,2}, {4,3}};
    }

    private void test3(){
        a = new int[][]{{2,2}, {2,3}, {2,7}, {6,6}, {5,2}};
        b = new int[][]{{2,3,4,5},{1,3,4,5}};
    }

    // ChatGPT 를 쓰지않고 풀이 ( 절대 사용 금지 ) 나에게 도움 X
    /*
    1. Point 는 각각의 시작 지점
    2. Routes 는 각각의 로봇들의 어디로 가야할지 루트 지정
    예제 1번 같이 4->2 [ 4,2 ]
    1번 로봇은 a의 index 3-> 1
    2번 로봇은 a의 index 0-> 2
    3번 로봇은 a의 index 1-> 3

    3. 모든 로봇은 해당 위치에서 최적의 장소를 탐색함.
    4. 그리고 각 로봇의 위치를 좌표를 반환함.
    5. 시작.

    # 처음으로 시작해야하는 건
    1. 로봇의 이동 경로를 하나씩 가져오는 것

    */

    public void start() {
        test3();
        Map<Integer,Location> ro = fineLocation(); // <- 로봇의 이동경로를 나열
        int qwang = move(ro); //  < 충돌 테스트

        System.out.println(" 몇번 부딫힘? "+qwang);
    }

    private int move(Map<Integer, Location> ro) {
        int count = 0;
        // 모든 로봇들의 이동위치를 가져와서
        List<Location> locations = new ArrayList<>(ro.values());
        // 거기서 가장 큰 범위를 가진놈을 가져오고
        int maxCount = locations.stream()
                .mapToInt(loc -> loc.getRoutes().size())
                .max()
                .orElse(0);
        // 그 만큼 반복을 실행
        for (int i = 0; i < maxCount; i++) {
            Map<String, Integer> positionMap = new HashMap<>(); // 같은 좌표에 , 몇대의 로복이 있는지 확인 배열로하면 확인이 어려우니 String 으로 체크

            for (Location loc : locations) {
                List<int[]> routes = loc.getRoutes();
                if (i >= routes.size()) continue; // 이미 도착한 로봇은 패스

                int[] pos = routes.get(i);
                String key = pos[0] + "," + pos[1];

                positionMap.put(key, positionMap.getOrDefault(key, 0) + 1); // 각 좌표에 맞게 로봇수를 표기함
            }

            for (int value : positionMap.values()) { // 모든 value 를 가져와서 로봇수가 2 이상이라면 충돌이라서 count++
                if (value >= 2) {
                    count++;
                }
            }
        }

        return count;
    }


    private Map<Integer, Location> fineLocation() {
        Map<Integer, Location> robots = new HashMap<>();
        int index = 0;

        for (int[] route : b) {
            List<int[]> fullRoute = new ArrayList<>();

            for (int i = 0; i < route.length - 1; i++) {
                int[] from = a[route[i] - 1];
                int[] to = a[route[i + 1] - 1];
                List<int[]> segment = getRoutes(from, to);

                // 경로 이어붙이기 전, 중복 좌표 제거
                if (!fullRoute.isEmpty()) {
                    int[] last = fullRoute.get(fullRoute.size() - 1);
                    int[] firstOfSegment = segment.get(0);

                    if (Arrays.equals(last, firstOfSegment)) {
                        segment.remove(0);
                    }
                }

                fullRoute.addAll(segment);
            }

            robots.put(index, new Location(fullRoute));
            index++;
        }

        return robots;
    }


    private List<int[]> getRoutes(int[] firstLoc, int[] endLoc) {
        // 여기서부터는 본격적인 최적의 루트 찾기
        // [ 1,4 -> 6,4 ] 여기서 중요한건 앞에 있는게 y 축임 즉 [y, x] 좌표로 되어있음. / 이럴경우 y 축만 5 상승하면 되기 때문에 최단의 경로
        // [ 3,2 -> 4,7 ] / 최단의 경로 : 3->4 로 먼저 이동 후 2->7로 이동 / 즉 앞에 있는 숫자가 먼저 맞춰지고 나서 뒤에 있는 숫자를 맞춰줌
        List<int[]> routes = new ArrayList<>();

        int sy = firstLoc[0], sx = firstLoc[1];
        int ey = endLoc[0], ex = endLoc[1];


        int dy = sy < ey ? 1 : -1;
        for (int y = sy; y != ey; y += dy) {
            routes.add(new int[]{y, sx});
        }

        routes.add(new int[]{ey, sx});


        int dx = sx < ex ? 1 : -1;
        for (int x = sx + dx; x != ex + dx; x += dx) {
            routes.add(new int[]{ey, x});
        }

        return routes;
    }

    public static class Location {
        List<int[]> routes;

        public Location(List<int[]> routes) {
            this.routes = routes;
        }

        public List<int[]> getRoutes() {
            return routes;
        }
    }
}
