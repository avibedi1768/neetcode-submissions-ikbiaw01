class Solution {
    public boolean isValidSudoku(char[][] board) {
        // each row
        for (int i = 0; i < 9; i++) {
            Set<Character> hs = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                // System.out.print("(" + i + "," + j + "), ");
                if (board[i][j] != '.')
                    if (!hs.add(board[i][j]))
                        return false;
            }

            // System.out.println();
        }

        // each col
        for (int j = 0; j < 9; j++) {
            Set<Character> hs = new HashSet<>();

            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.')
                    if (!hs.add(board[i][j]))
                        return false;
            }
        }

        // each box
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                // System.out.println(i + " " + j);
                Set<Character> hs = new HashSet<>();

                for (int p = i; p <= i + 2; p++) {
                    for (int q = j; q <= j + 2; q++) {
                        if (board[p][q] != '.')
                            if (!hs.add(board[p][q])) {
                                // System.out.println(hs);
                                // System.out.println(p + " " + q);
                                return false;
                            }
                    }
                }
            }
        }

        return true;
    }
}
