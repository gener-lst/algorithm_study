package ch06.farthest;

import java.util.*;

public class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Map<Integer, Boolean> visited = new HashMap<>();

    public int solution(int n, int[][] edge) {
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
            visited.put(i, false);
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        return bfs(1);
    }

    private int bfs(int node) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{node, 0});
        visited.put(node, true);

        int maxDist = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            int curVertex = cur[0];
            int dist = cur[1];

            if(maxDist < dist) {
                maxDist = dist;
                count = 1;
            } else if(maxDist == dist) count ++;

            for(int nextVertex: graph.get(curVertex)) {
                if(!visited.get(nextVertex)) {
                    visited.put(nextVertex, true);
                    queue.offer(new int[]{nextVertex, dist + 1});
                }
            }
        }

        return count;
    }
}
