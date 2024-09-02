package ch10.petroleum;

public class Solution1 {
    public static int[] dc = new int[] {0, 0, 1, -1};
    public static int[] dr = new int[] {1, -1, 0, 0};

    public int solution(int[][] land) {
        boolean[][] visited;
        int maxCount = 0;

        for(int c = 0; c < land[0].length; c++) {
            visited = new boolean[land.length][land[0].length];
            int count = 0;
            for(int r = 0; r < land.length; r++) {
                if(land[r][c] == 1 && !visited[r][c]) {
                    count += dfs(r, c, land, visited);
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    private int dfs(int r, int c, int[][] land, boolean[][] visited) {
        visited[r][c] = true;
        int count = 1;

        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >= 0 && nc >= 0 && nr < land.length && nc < land[0].length && !visited[nr][nc] && land[nr][nc] == 1) {
                count += dfs(nr, nc, land, visited);
            }
        }

        return count;
    }
}

