/**
 * 打家劫舍
 */
public class _198 {

    // 边界状态:dp[0] = nums[0],dp[1] = max(nums[0],nums[1])
    // 状态转移方程:dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
    public int rob(int[] nums) {
        if (nums.length == 0)
        {
            return 0;
        }else if (nums.length == 1)
        {
            return nums[0];
        }else {
            int[] dp = new int[nums.length + 2];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[nums.length - 1];
        }
    }
}
