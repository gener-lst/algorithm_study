package ch08.taxi;

import java.util.*;

public class Answer {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] fare : fares) {
            map.get(fare[0]).add(new int[]{fare[1], fare[2]});
            map.get(fare[1]).add(new int[]{fare[0], fare[2]});
        }

        int[] distFromS = dijkstra(map, s, n);
        int[] distFromA = dijkstra(map, a, n);
        int[] distFromB = dijkstra(map, b, n);

        int minCost = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            if (distFromS[i] != Integer.MAX_VALUE &&
                    distFromA[i] != Integer.MAX_VALUE &&
                    distFromB[i] != Integer.MAX_VALUE) {
                int cost = distFromS[i] + distFromA[i] + distFromB[i];
                minCost = Math.min(minCost, cost);
            }
        }

        return minCost;
    }

    private int[] dijkstra(Map<Integer, List<int[]>> map, int start, int n) {
        int[] fare = new int[n + 1];
        Arrays.fill(fare, Integer.MAX_VALUE);
        fare[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];

            for (int[] edge : map.get(node)) {
                int nextNode = edge[0];
                int nextCost = cost + edge[1];

                if (nextCost < fare[nextNode]) {
                    fare[nextNode] = nextCost;
                    pq.add(new int[]{nextNode, nextCost});
                }
            }
        }
        return fare;
    }
}

