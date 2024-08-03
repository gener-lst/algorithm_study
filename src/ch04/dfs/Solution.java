package ch04.dfs;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    static Set<String> visited = new HashSet<>();

    static void dfs(Map<String, List<String>> graph, String current) {
        // *---------------------------------------*
        // 그래프를 방문하며 처리해야할 일을 여기서 한다
        // (예시)
        // if (current == value) {
        //     << 현재 노드가 특정 값을 만족할 때 해야할 일 >>
        //     return current;
        // }
        // *---------------------------------------*
        visited.add(current);
        for (String v : graph.get(current)) {
            if (!visited.contains(v)) {
                dfs(graph, v);
            }
        }
    }
}
