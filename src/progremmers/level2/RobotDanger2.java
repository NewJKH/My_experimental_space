package progremmers.level2;

import java.util.*;

public class RobotDanger2 {
    private int[][] points, routes;

    public void start() {
        test3();
        Map<Integer, Location> robots = generateRobotRoutes();
        int dangerCount = countDangerMoments(robots);
        System.out.println("쾅 ! :"+dangerCount);
    }

    // 테스트 케이스
    private void test1() {
        points = new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        routes = new int[][]{{4, 2}, {1, 3}, {2, 4}};
    }

    private void test2() {
        points = new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        routes = new int[][]{{4, 2}, {1, 3}, {4, 2}, {4, 3}};
    }

    private void test3() {
        points = new int[][]{{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}};
        routes = new int[][]{{2, 3, 4, 5}, {1, 3, 4, 5}};
    }

    // 로봇마다 경로 생성
    private Map<Integer, Location> generateRobotRoutes() {
        Map<Integer, Location> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            List<int[]> fullRoute = new ArrayList<>();
            for (int j = 0; j < routes[i].length - 1; j++) {
                int[] from = points[routes[i][j] - 1];
                int[] to = points[routes[i][j + 1] - 1];
                fullRoute.addAll(generateSegment(from, to));
            }
            map.put(i, new Location(fullRoute));
        }
        return map;
    }

    // 한 구간의 최단 경로 생성
    private List<int[]> generateSegment(int[] from, int[] to) {
        List<int[]> path = new ArrayList<>();

        int fy = from[0], fx = from[1];
        int ty = to[0], tx = to[1];

        int yStep = fy <= ty ? 1 : -1;
        int xStep = fx <= tx ? 1 : -1;

        // y 먼저 이동
        for (int y = fy; y != ty; y += yStep) {
            path.add(new int[]{y, fx});
        }
        path.add(new int[]{ty, fx}); // y 이동 마지막 좌표

        // x 이동
        for (int x = fx + xStep; x != tx + xStep; x += xStep) {
            path.add(new int[]{ty, x});
        }

        return path;
    }

    // 충돌 카운트
    private int countDangerMoments(Map<Integer, Location> robots) {
        int count = 0;
        List<Map.Entry<Integer, Location>> entries = new ArrayList<>(robots.entrySet());

        int maxStep = entries.stream()
                .mapToInt(e -> e.getValue().routes.size())
                .max()
                .orElse(0);

        for (int time = 1; time < maxStep; time++) {  // ❗ 1부터 시작: 0은 출발 전이므로 제외
            Map<String, Set<Integer>> positionMap = new HashMap<>();

            for (Map.Entry<Integer, Location> entry : entries) {
                int robotId = entry.getKey();
                List<int[]> route = entry.getValue().routes;
                if (time >= route.size()) continue;

                int[] pos = route.get(time);
                String key = pos[0] + "," + pos[1];

                positionMap
                        .computeIfAbsent(key, k -> new HashSet<>())
                        .add(robotId);
            }

            for (Set<Integer> robotSet : positionMap.values()) {
                if (robotSet.size() >= 2) {
                    count++;
                }
            }
        }

        return count;
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
