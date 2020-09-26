/**
 * 大子序和
 */
public class _53 {
    /**
     * 动态规划法
     * @param nums
     * @return
     */
    // 单一状态dp[i]:代表以i为结尾的最大字段和
    // 状态转移方程:dp[i] = max(dp[i - 1] + nums[i], nums[i - 1])
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
        {
            return 0;
        }
        else if (nums.length == 1)
        {
            return nums[0];
        }
        else
        {
            int[] dp = new int[nums.length];
            int max = nums[0];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                if (dp[i] > max)
                {
                    max = dp[i];
                }
            }
            return max;
        }
    }

    /**
     * 遍历求解O(n)
     * @param nums
     * @return
     */
    public int _maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (sum > 0)
            {
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            if (sum >= maxSum)
            {
                maxSum = sum;
            }
        }

        return maxSum;
    }

    /**
     * 分治法
     * @param nums
     * @return
     */
    public int __maxSubArray(int[] nums)
    {
        return recur(nums, 0, nums.length - 1);
    }

    private int recur(int[] nums, int p, int r)
    {
        if (p < r)
        {
            int mid = (p + r) / 2;
            int left = recur(nums, p, mid);
            int right = recur(nums, mid + 1, r);
            int cross = crossMax(nums, p, mid, r);
            return Math.max(cross, Math.max(left, right));
        }else {
            return nums[p];
        }
    }

    private int crossMax(int[] nums, int p, int mid, int r)
    {
        int leftSum = 0;
        int leftMaxSum = Integer.MIN_VALUE;

        int rightSum = 0;
        int rightMaxSum = Integer.MIN_VALUE;

        for (int i = mid; i >= p; i--) {
            leftSum += nums[i];
            if (leftSum >= leftMaxSum)
            {
                leftMaxSum = leftSum;
            }
        }

        for (int i = mid + 1; i <= r; i++) {
            rightSum += nums[i];
            if (rightSum >= rightMaxSum)
            {
                rightMaxSum = rightSum;
            }
        }

        return leftMaxSum + rightMaxSum;
    }

    public static void main(String[] args) {
        _53 v = new _53();
        int i = v.maxSubArray(new int[]{8,-19,5,-4,20});
        System.out.println(i);
    }
}
