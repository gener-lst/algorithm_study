package ch08.network;

import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 그래프 초기화
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] time : times) {
            // u -> v 로 가는 경로와 가중치 w를 그래프에 추가
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        return dijkstra(graph, k, n);
    }

    private int dijkstra(Map<Integer, List<int[]>> graph, int start, int n) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        // 우선순위 큐 초기화 (최소 힙)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int time = cur[1];

            if (time > distance[node]) continue;

            // 인접 노드 확인
            for (int[] edge : graph.get(node)) {
                int nextNode = edge[0];
                int nextTime = time + edge[1];

                if (nextTime < distance[nextNode]) {
                    distance[nextNode] = nextTime;
                    pq.add(new int[]{nextNode, nextTime});
                }
            }
        }
        return find(distance, n);
    }

    private int find(int[] distance, int n) {
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, distance[i]);
        }

        return maxTime;
    }
}

