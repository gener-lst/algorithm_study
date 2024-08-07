package ch04.bipartite;

import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Arrays.fill(visited, 0); // 0은 색칠되지 않은 상태를 나타냅니다.

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                // BFS를 사용하여 그래프 색칠하기
                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);
                visited[i] = 1; // 시작 정점을 1로 색칠합니다.

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor : graph[node]) {
                        if (visited[neighbor] == 0) {
                            // 이웃 정점을 반대 색으로 색칠합니다.
                            visited[neighbor] = -visited[node];
                            queue.add(neighbor);
                        } else if (visited[neighbor] == visited[node]) {
                            // 인접한 두 정점이 같은 색으로 색칠되어 있다면, 이분 그래프가 아닙니다.
                            return false;
                        }
                    }
                }
            }
        }
        return true; // 모든 정점을 색칠할 수 있다면, 이분 그래프입니다.
    }
}
