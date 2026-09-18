class Solution {
    public void solveSudoku(char[][] b) {
        solve(b);
    }

    boolean solve(char[][] b) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (b[r][c] == '.') {
                    for (char x = '1'; x <= '9'; x++) {
                        if (valid(b, r, c, x)) {
                            b[r][c] = x;
                            if (solve(b)) return true;
                            b[r][c] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean valid(char[][] b, int r, int c, char x) {
        for (int i = 0; i < 9; i++) {
            if (b[r][i] == x || b[i][c] == x)
                return false;

            int R = 3 * (r / 3) + i / 3;
            int C = 3 * (c / 3) + i % 3;

            if (b[R][C] == x) return false;
        }
        return true;
    }
}