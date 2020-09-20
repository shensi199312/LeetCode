/**
 * 跳跃游戏(贪心)
 * 每次跳跃跳跃到可以跳跃更远位置的点
 * 如i可以跳跃到i+1...i+k,选择i+1到i+k中可以跳跃到更远位置的点作为i跳跃的点
 */
public class _55 {

    public boolean _canJump(int[] nums)
    {
        int[] maxIdx = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            maxIdx[i] = i + nums[i];
        }
        int jump = 0;
        int max = maxIdx[0];
        while (jump < maxIdx.length && jump <= max)
        {
            if (maxIdx[jump] > max)
            {
                max = maxIdx[jump];
            }
            jump++;
        }
        return jump == maxIdx.length;
    }

    public boolean canJump(int[] nums) {
        return getClosestIdx(nums, nums.length - 1);
    }

    public boolean getClosestIdx(int[] nums, int n)
    {
        if (n == 0)
        {
            return true;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] >= n - i)
            {
                return getClosestIdx(nums, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _55 v = new _55();
        boolean b = v.canJump(new int[]{3,2,1,0,4});
        System.out.println(b);
    }
}
