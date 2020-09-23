/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class _34 {


    public int[] _searchRange(int[] nums, int target)
    {
        int p = 0;
        int r= nums.length - 1;

        while (p <= r)
        {
            int mid = (p + r) / 2;
            if (nums[mid] == target)
            {
                int start = mid;
                int end = mid;
                while (start >= p && nums[start] == target)
                {
                    start--;
                }
                while (end <= r && nums[end] == target)
                {
                    end++;
                }
                return new int[]{start + 1, end - 1};
            }
            else if (nums[mid] > target)
            {
                r = mid - 1;
            }else {
                p = mid + 1;
            }
        }

        return new int[]{-1,-1};
    }


    public int[] searchRange(int[] nums, int target) {
        return recur(nums, 0, nums.length - 1, target);
    }

    public int[] recur(int[] nums, int p, int r, int target)
    {
        if (p <= r)
        {
            int mid = (p + r) / 2;
            if (nums[mid] == target)
            {
                int start = mid;
                int end = mid;
                while (start >= p && nums[start] == target)
                {
                    start--;
                }
                while (end <= r && nums[end] == target)
                {
                    end++;
                }
                return new int[]{start + 1, end - 1};
            }
            else if (nums[mid] > target)
            {
                return recur(nums, p, mid - 1, target);
            }else {
                return recur(nums, mid + 1, r, target);
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        _34 v = new _34();
        int[] ints = v.searchRange(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(ints);
    }
}
