package ch05.maze;

import java.util.*;

public class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    int rowLength = 0;
    int colLength = 0;
    boolean[][] visited;
    int answer = 0;

    public int solution(String[] maps) {
        rowLength = maps.length;
        colLength = maps[0].length();
        int[] startLocation = new int[2];
        int[] leverLocation = new int[2];
        int[] endLocation = new int[2];

        for(int i = 0; i < rowLength; i++) {
            for(int j = 0; j < colLength; j++) {
                char ch = maps[i].charAt(j);
                if (ch == 'S') {
                    startLocation[0] = i;
                    startLocation[1] = j;
                } else if (ch == 'L') {
                    leverLocation[0] = i;
                    leverLocation[1] = j;
                } else if (ch == 'E') {
                    endLocation[0] = i;
                    endLocation[1] = j;
                }
            }
        }

        int leverDist = bfs(maps, startLocation, leverLocation);
        if (leverDist == -1) return -1; // 레버에 도달할 수 없는 경우

        int exitDist = bfs(maps, leverLocation, endLocation);
        if (exitDist == -1) return -1; // 출구에 도달할 수 없는 경우

        answer = leverDist + exitDist;
        return answer;
    }

    private int bfs(String[] maps, int[] start, int[] target) {
        visited = new boolean[rowLength][colLength];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if(r == target[0] && c == target[1]) {
                return dist;
            }

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(0 <= nr && nr < rowLength && 0 <= nc && nc < colLength && maps[nr].charAt(nc) != 'X' && !visited[nr][nc]) {
                    queue.offer(new int[]{nr, nc, dist + 1});
                    visited[nr][nc] = true;
                }
            }
        }
        return -1; // 목표 지점에 도달할 수 없는 경우
    }
}

