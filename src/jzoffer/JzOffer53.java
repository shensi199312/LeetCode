package jzoffer;

/**
 * 在排序数组中查找数字 I
 */
public class JzOffer53 {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
        {
            return 0;
        }
        return recur(nums, 0, nums.length - 1, target, 0);
    }

    private int recur(int[] nums, int p, int r, int target, int count)
    {
        if (p < r)
        {
            int q = (p + r) / 2;

            if (nums[q] == target)
            {
                count = recur(nums, p, q, target, count);
                return recur(nums, q + 1, r, target, count);
            }
            else if (nums[q] < target)
            {
                return recur(nums, q + 1, r, target, count);
            }
            else {
                return recur(nums, p, q - 1, target, count);
            }
        }else {
            count += (nums[p] == target ? 1 : 0);
            return count;
        }
    }

    public static void main(String[] args) {
        JzOffer53 jzOffer53 = new JzOffer53();

        int search = jzOffer53.search(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(search);
    }
}
