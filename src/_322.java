/**
 * 零钱兑换
 */
public class _322 {

    // 状态转移方程:dp[i] = min(1 + dp[i - coin[0]], 1 + dp[i - coin[1]] ... 1 + dp[i - coin[n]])
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (coin <= i && dp[i - coin] != -1)
                {
                    min = Math.min(1 + dp[i - coin], min);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        _322 v = new _322();
        int i = v.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(i);
    }
}
