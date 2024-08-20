package ch08.taxi;

import java.util.*;

public class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] fare : fares) {
            map.get(fare[0]).add(new int[]{fare[1], fare[2]});
            map.get(fare[1]).add(new int[]{fare[0], fare[2]});
        }

        return dijkstra(map, a, b, s, n);
    }

    private int dijkstra(Map<Integer, List<int[]>> map, int a, int b, int s, int n) {
        int[] fare = new int[n + 1];
        Arrays.fill(fare, Integer.MAX_VALUE);
        fare[s] = 0;
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparing(t -> t[1]));
        pq.add(new int[]{s, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];

            if(visited[a] && visited[b]) return cost;

            for (int[] edge : map.get(node)) {
                int nextNode = edge[0];
                int nextCost = cost + edge[1];

                if (nextCost < fare[nextNode]) {
                    visited[nextNode] = true;
                    fare[nextNode] = nextCost;
                    pq.add(new int[]{nextNode, nextCost});
                }
            }
        }
        return 0;
    }
}
