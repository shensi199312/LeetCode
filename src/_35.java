/**
 * 搜索插入位置
 */
public class _35 {
    public int searchInsert(int[] nums, int target) {
        int p = 0;
        int r = nums.length - 1;

        while (p <= r)
        {
            int mid = (p + r) / 2;

            if (nums[mid] == target)
            {
                return mid;
            }
            else if (nums[mid] > target)
            {
                r = mid - 1;
            }
            else
            {
                p = mid + 1;
            }
        }
        if (p == nums.length)
        {
            return p;
        }else {
            return nums[p] > target ? p : p + 1;
        }
    }
}
