package progremmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Miro {
    public static void main(String[] args) {
        String[] maps = new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        String[] maps1 = new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};

        char[][] f = format(maps1);
        int toLever = bfs(f, 'S', 'L');
        if (toLever == -1) {
            System.out.println("레버까지 갈 수 없음");
            return;
        }

        int toExit = bfs(f, 'L', 'E');
        if (toExit == -1) {
            System.out.println("출구까지 갈 수 없음");
            return;
        }
        System.out.println(toLever+toExit);
    }
    /*
        BFS 1번: 시작점 S에서 레버 L까지 최단 거리 구하기
        BFS 2번: 레버 L에서 출구 E까지 최단 거리 구하기
        두 경로 중 하나라도 도달 불가능하면 -1 리턴
        둘 다 가능하면 → 거리 합계 리턴
     */
    private static char[][] format(String[] maps){
        char[][] map = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        System.out.println(Arrays.deepToString(map));
        return map;
    }

    private static int bfs(char[][] map, char startChar, char endChar) {
        int n = map.length;
        int m = map[0].length;
        boolean[][] visited = new boolean[n][m];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Node> queue = new LinkedList<>();

        // 시작 좌표 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == startChar) {
                    queue.offer(new Node(i, j, 0));
                    visited[i][j] = true;
                    break;
                }
            }
        }

        // BFS 시작
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (map[now.x][now.y] == endChar) {
                return now.dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] != 'X') {
                        visited[nx][ny] = true;
                        queue.offer(new Node(nx, ny, now.dist + 1));
                    }
                }
            }
        }

        return -1;
    }
    static class Node {
        int x, y, dist;
        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

}
