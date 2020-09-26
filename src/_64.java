/**
 * 最小路径和
 */
public class _64 {

    public int minPathSum(int[][] grid) {
        if (grid.length == 0)
        {
            return 0;
        }
        else if (grid.length == 1)
        {
            int sum = 0;
            for (int i = 0; i < grid[0].length; i++) {
                sum += grid[0][i];
            }
            return sum;
        }
        else if (grid[0].length == 1)
        {
            int sum = 0;
            for (int i = 0; i < grid.length; i++) {
                sum += grid[i][0];
            }
            return sum;
        }
        else {
            int r = grid.length;
            int c = grid[0].length;
            int[][] dp = new int[r][c];

            dp[0][0] = grid[0][0];

            // 处理基状态(第一行)
            for (int i = 1; i < c; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }

            // 处理基状态(第一列)
            for (int i = 1;i < r;i++)
            {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }

            for (int i = 1; i < r; i++) {
                for (int j = 1; j < c; j++) {
                    // 状态转移方程
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }

            return dp[r - 1][c - 1];
        }

    }
}
