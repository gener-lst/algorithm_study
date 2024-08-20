package ch05.fastest;

import java.util.*;

public class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            answer[i] = check(places[i]);
        }
        return answer;
    }

    private int check(String[] place) {
        for (int i = 0; i < 5; i++) {
            if (place[i].contains("P")) {
                for (int j = 0; j < 5; j++) {
                    if (place[i].charAt(j) == 'P') {
                        if (!bfs(i, j, place)) return 0;
                    }
                }
            }
        }
        return 1;
    }

    private boolean bfs(int sr, int sc, String[] place) {
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        queue.offer(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if (dist > 0 && place[r].charAt(c) == 'P') return false;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < 5 && nc < 5 && !visited[nr][nc]) {
                    if (dist + 1 <= 2 && place[nr].charAt(nc) != 'X') {
                        queue.offer(new int[]{nr, nc, dist + 1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return true;
    }
}