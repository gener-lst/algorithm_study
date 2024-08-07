package ch04.nQueen;

public class Solution {
    static int answer = 0;

    public int solution(int n) {
        int[][] map = new int[n][n];
        dfs(map, n, 0);
        return answer;
    }

    private void dfs(int[][] map, int n, int queenCount) {
        if (queenCount == n) {
            answer += 1;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(map, queenCount, i, n)) {
                map[queenCount][i] = 1;
                dfs(map, n, queenCount + 1);
                map[queenCount][i] = 0;
            }
        }
    }

    private boolean isSafe(int[][] map, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (map[i][col] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (map[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (map[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
