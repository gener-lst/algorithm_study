package ch10.petroleum;

import java.util.*;

public class Solution2 {
    public static boolean[][] visited;
    public static int[] dr = {1, 0, -1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public int solution(int[][] land) {
        visited = new boolean[land.length][land[0].length];
        Map<Integer, Integer> totalCount = new HashMap<>();

        int answer = 0;

        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[0].length; c++) {
                if (land[r][c] == 1 && !visited[r][c]) {
                    Set<Integer> cols = new HashSet<>();
                    int count = bfs(r, c, land, cols);

                    for (int col : cols) {
                        totalCount.put(col, totalCount.getOrDefault(col, 0) + count);
                    }
                }
            }
        }

        for (int value : totalCount.values()) {
            answer = Math.max(answer, value);
        }

        return answer;
    }

    private int bfs(int r, int c, int[][] land, Set<Integer> cols) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];
            count++;
            cols.add(cc);

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (nr >= 0 && nr < land.length && nc >= 0 && nc < land[0].length && land[nr][nc] == 1 && !visited[nr][nc]) {
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        return count;
    }
}
