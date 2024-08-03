package ch05.shortestPath;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        int rowLength = maps.length;
        int colLength = maps[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];
        int answer = 0;

        Queue<int[]> queue = new ArrayDeque();
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if(r == rowLength - 1 && c == colLength - 1) {
                return dist;
            }


            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(0 <= nr && nr < rowLength && 0 <= nc && nc < colLength && maps[nr][nc] == 1) {
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
