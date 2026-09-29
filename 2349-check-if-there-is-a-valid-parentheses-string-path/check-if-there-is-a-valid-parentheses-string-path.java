class Solution {
    Boolean[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        dp = new Boolean[m][n][m + n + 1];
        return solve(grid, 0, 0, 0);
    }
    public boolean solve(char[][] grid, int i, int j, int open) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[i][j] == '(') {
            open++;
        } else {
            open--;
        }
        if (open < 0) {
            return false;
        }
        if (i == m - 1 && j == n - 1) {
            return open == 0;
        }
        if (dp[i][j][open] != null) {
            return dp[i][j][open];
        }
        boolean ans = false;
        if (i + 1 < m) {
            ans = solve(grid, i + 1, j, open);
        }
        if (!ans && j + 1 < n) {
            ans = solve(grid, i, j + 1, open);
        }
        dp[i][j][open] = ans;
        return ans;
    }
}