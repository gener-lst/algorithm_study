package ch06.laboratory3;

import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int n, m, minTime, emptyCells;
    static int[][] map;
    static List<int[]> virusPositions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        virusPositions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virusPositions.add(new int[]{i, j});
                }
                if (map[i][j] == 0) {
                    emptyCells++;
                }
            }
        }

        minTime = Integer.MAX_VALUE;
        selectVirusPositions(new int[m], 0, 0);
        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }

    private static void selectVirusPositions(int[] selected, int count, int start) {
        if (count == m) {
            bfs(selected);
            return;
        }

        for (int i = start; i < virusPositions.size(); i++) {
            selected[count] = i;
            selectVirusPositions(selected, count + 1, i + 1);
        }
    }

    private static void bfs(int[] selected) {
        int[][] tempMap = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            tempMap[i] = map[i];
        }

        for (int index : selected) {
            int[] pos = virusPositions.get(index);
            queue.offer(new int[]{pos[0], pos[1], 0});
            visited[pos[0]][pos[1]] = true;
        }

        int time = 0;
        int infectedCells = 0;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int r = point[0];
            int c = point[1];
            int t = point[2];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && tempMap[nr][nc] != 1) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, t + 1});
                    if (tempMap[nr][nc] == 0) {
                        infectedCells++;
                        time = t + 1;
                    }
                }
            }
        }

        if (infectedCells == emptyCells) {
            minTime = Math.min(minTime, time);
        }
    }
}

