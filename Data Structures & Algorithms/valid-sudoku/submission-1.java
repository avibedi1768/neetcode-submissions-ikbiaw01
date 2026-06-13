class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> hs = new HashSet<>();
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.' && !hs.add(board[i][j]))
                    return false;
        }

        for (int j = 0; j < 9; j++) {
            Set<Character> hs = new HashSet<>();
            for (int i = 0; i < 9; i++)
                if (board[i][j] != '.' && !hs.add(board[i][j]))
                    return false;
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                // start of each 3x3 square
                Set<Character> sq = new HashSet<>();

                for (int p = 0; p < 3; p++) {
                    for (int q = 0; q < 3; q++) {
                        // repeat in square
                        if (board[i + p][j + q] != '.' && !sq.add(board[i + p][j + q]))
                            return false;
                    }
                }
            }
        }

        return true;
    }
}
