package ch03.fatigue;

class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return dfs(k, dungeons, visited);
    }

    private int dfs(int fatigue, int[][] dungeons, boolean[] visited) {
        int maxCount = 0;
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) {
                visited[i] = true;
                int currentCount = 1 + dfs(fatigue - dungeons[i][1], dungeons, visited);
                maxCount = Math.max(maxCount, currentCount);
                visited[i] = false;
            }
        }
        return maxCount;
    }
}

