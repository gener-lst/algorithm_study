package ch07.treasure;

import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] hole) {
        boolean[][] trap = new boolean[n+1][m+1];
        for (int[] h : hole) {
            trap[h[0]][h[1]] = true;
        }

        boolean[][][] visited = new boolean[n+1][m+1][2];
        Queue<int[]> queue = new ArrayDeque<>();
        visited[1][1][0] = true;
        queue.add(new int[]{ 1, 1, 0, 0 });

        int[] dr = { 0, 1, 0, -1, 0, 2, 0, -2 };
        int[] dc = { 1, 0, -1, 0, 2, 0, -2, 0 };

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int r = cur[0], c = cur[1], jumped = cur[2], dist = cur[3];

            if (r == n && c == m) return dist;

            for (int d = 0; d < ((jumped == 1) ? 4 : 8); d++) {
                int nr = r + dr[d], nc = c + dc[d];
                int nj = (jumped == 1) ? 1 : (d / 4);

                if (nr >= 1 && nr <= n && nc >= 1 && nc <= m) {
                    if (!visited[nr][nc][nj] && !trap[nr][nc]) {
                        visited[nr][nc][nj] = true;
                        queue.add(new int[]{ nr, nc, nj, dist + 1 });
                    }
                }
            }
        }
        return -1;
    }
}