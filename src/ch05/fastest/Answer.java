package ch05.fastest;

import java.util.*;

class Answer {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // 초기값 세팅
        int[] dr = {1, -1, 0, 0, 1, 1, -1, -1};
        int[] dc = {0, 0, 1, -1, 1, -1, 1, -1};
        int rowLength = grid.length;
        int colLength = grid[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];

        // bfs
        // 시작점 큐에 넣기
        Queue<int[]> queue = new ArrayDeque();

        if(grid[0][0] == 1 || grid[rowLength - 1][colLength - 1] == 1) {
            return -1;
        }

        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        // while
        while(!queue.isEmpty()) {
            // 방문(큐에서 dequeue)

            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            // 도착했나? 체크 => return
            if(r == rowLength - 1 && c == colLength - 1) {
                return dist;
            }

            // 예약
            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(0 <= nr && nr < rowLength && 0 <= nc && nc < colLength && grid[nr][nc] == 0) {
                    if(!visited[nr][nc]) {
                        queue.offer(new int[]{nr, nc, dist + 1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return -1;
    }
}

