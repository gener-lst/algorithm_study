package ch06.powerGrid;

import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int min = n;

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] e : wires) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        for (int[] e : wires) {
            int v1 = e[0];
            int v2 = e[1];

            boolean[] visited = new boolean[n + 1];

            graph.get(v1).remove(Integer.valueOf(v2));
            graph.get(v2).remove(Integer.valueOf(v1));

            int count = dfs(graph, 1, visited);

            int diff = Math.abs(count - (n - count));
            min = Math.min(min, diff);

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        return min;
    }

    private int dfs(Map<Integer, List<Integer>> graph, int v, boolean[] visited) {
        visited[v] = true;
        int count = 1;

        for (int next : graph.get(v)) {
            if (!visited[next]) {
                count += dfs(graph, next, visited);
            }
        }

        return count;
    }
}
