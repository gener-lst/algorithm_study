package ch06.word;

public class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    int rowLength;
    int colLength;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        rowLength = board.length;
        colLength = board[0].length;
        visited = new boolean[rowLength][colLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, int length, String word) {
        if (length == word.length()) {
            return true;
        }

        if (r < 0 || r >= rowLength || c < 0 || c >= colLength || visited[r][c] || board[r][c] != word.charAt(length)) {
            return false;
        }

        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (dfs(board, nr, nc, length + 1, word)) {
                return true;
            }
        }

        visited[r][c] = false;
        return false;
    }
}

