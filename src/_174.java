/**
 * 地下城游戏
 * 思路:右下角到左上角
 */
public class _174 {

    // dp[i][j]代表在进入位置i,j时至少剩余的血量
    // 状态转移方程:
    // 基状态(最后一行):dp[0][i] = max(1, dp[r - 1][i + 1] - dungeon[r - 1][i])
    // 基状态(最后一列):dp[i][0] = max(1, dp[i + 1][c - 1] - dungeon[i][c - 1])
    // dp[i][j] = max(1, min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j])
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0)
        {
            return 1;
        }
        int r = dungeon.length;
        int c = dungeon[0].length;
        int[][] dp = new int[r][c];
        dp[r - 1][c - 1] = Math.max(1, 1 - dungeon[r - 1][c - 1]);

        // 基状态(最后一行)
        for (int i = c - 2; i >= 0; i--) {
            dp[r - 1][i] = Math.max(1, dp[r - 1][i + 1] - dungeon[r - 1][i]);
        }

        // 基状态(最后一列)
        for (int i = r - 2; i >= 0; i--) {
            dp[i][c - 1] = Math.max(1, dp[i + 1][c - 1] - dungeon[i][c - 1]);
        }

        for (int i = r - 2;i >= 0;i--)
        {
            for (int j = c - 2; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
