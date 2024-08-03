package ch06.farthest;

import java.util.*;

public class Answer {
    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        return bfs(graph, 1);
    }

    private int bfs(Map<Integer, List<Integer>> graph, int start) {
        int maxDist = -1;
        int count = 0;

        boolean[] visited = new boolean[graph.size() + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            int curVertex = cur[0];
            int dist = cur[1];

            if(maxDist < dist) {
                maxDist = dist;
                count = 0;
            }
            count ++;

            for(int nextVertex: graph.get(curVertex)) {
                if(!visited[nextVertex]) {
                    queue.offer(new int[]{nextVertex, dist + 1});
                    visited[nextVertex] = true;
                }
            }
        }
        return count;
    }
}
