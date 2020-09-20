/**
 * 跳跃游戏II：求最小跳跃次数
 */
public class _45 {

    public int jump(int[] nums) {
        if (nums.length < 2)
        {
            return 0;
        }
        int maxIdx = nums[0];
        int preMaxIdx = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (i > maxIdx)
            {
                maxIdx = preMaxIdx;
                count++;
            }
            if (preMaxIdx < i + nums[i])
            {
                preMaxIdx = i + nums[i];
            }
        }
        return count;
    }
}
