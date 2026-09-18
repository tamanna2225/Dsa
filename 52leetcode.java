class Solution {
    int ans = 0;

    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] d1 = new boolean[2*n];
        boolean[] d2 = new boolean[2*n];

        solve(0, n, col, d1, d2);
        return ans;
    }

    void solve(int r, int n, boolean[] col, boolean[] d1, boolean[] d2) {
        if (r == n) {
            ans++;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col[c] || d1[r-c+n] || d2[r+c])
                continue;

            col[c] = d1[r-c+n] = d2[r+c] = true;
            solve(r + 1, n, col, d1, d2);
            col[c] = d1[r-c+n] = d2[r+c] = false;
        }
    }
}