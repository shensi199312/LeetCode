import java.util.LinkedList;

/**
 * 最长上升子序列
 * 思路1:动态规划,dp[i]代表以i为结尾的最大上升子序列的个数
 * 思路2:单调栈
 */
public class _300 {


    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
        {
            return 0;
        }
        else if (nums.length == 1)
        {
            return 1;
        }else {
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int maxLen = Integer.MIN_VALUE;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] > nums[j])
                    {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                if (dp[i] >= maxLen)
                {
                    maxLen = dp[i];
                }
            }
            return maxLen;
        }
    }

    public int _lengthOfLIS(int[] nums) {
        if (nums.length == 0)
        {
            return 0;
        }
        else if (nums.length == 1)
        {
            return 1;
        }else {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > list.getLast())
                {
                    list.add(nums[i]);
                }else {
                    // 此处的查询可以优化成二分查找既可以得到n * lgn的算法
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j) > nums[i])
                        {
                            list.set(j, nums[i]);
                            break;
                        }
                    }
                }
            }
            return list.size();
        }
    }

    public static void main(String[] args) {
        _300 v = new _300();
        int i = v.lengthOfLIS(new int[]{4, 4, 4, 4, 4});
        System.out.println(i);
    }
}
