class Solution {
    boolean vis[][];
    int m, n;
    int drow[] = {-1, 0, 1, 0}, dcol[] = {0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    vis[i][j] = true;

                    boolean curr = func(board, word, 1, i, j);

                    if (curr)
                        return curr;

                    vis[i][j] = false;
                }
            }
        }

        return false;
    }

    boolean func(char[][] board, String s, int index, int i, int j) {
        if (index == s.length())
            return true;

        char ch = s.charAt(index);

        for (int k = 0; k < 4; k++) {
            int row = i + drow[k], col = j + dcol[k];

            if (row >= 0 && row < m && col >= 0 && col < n && vis[row][col] == false
                && board[row][col] == ch) {
                vis[row][col] = true;
                boolean curr = func(board, s, index + 1, row, col);
                if (curr)
                    return true;

                vis[row][col] = false;
            }
        }

        return false;
    }
}
