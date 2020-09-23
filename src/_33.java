/**
 * 搜索旋转排序数组
 * 二分变种:考虑区间的begin和mid大小,判断旋转区间的大致范围
 */
public class _33 {


    public int search(int[] nums, int target) {
        int p = 0;
        int r = nums.length - 1;
        while (p <= r)
        {
            int mid = (p + r) / 2;
            if (target == nums[mid])
            {
                return mid;
            }
            else if (target < nums[mid])
            {
                if (nums[p] < nums[mid])
                {
                    if (target >= nums[p])// 在升序区间中
                    {
                        r = mid - 1;
                    }else { // 在旋转区间中
                        p = mid + 1;
                    }
                }
                else if (nums[p] > nums[mid]){
                    r = mid - 1;
                }
                else if (nums[p] == nums[mid]){
                    p = mid + 1;
                }
            }else {
                if (nums[p] < nums[mid])
                {
                    p = mid + 1;
                }
                else if (nums[p] > nums[mid]){
                    if (target >= nums[p])
                    {
                        r = mid - 1;
                    }else {
                        p = mid + 1;
                    }
                }
                else if (nums[p] == nums[mid]){
                    p = mid + 1;
                }
            }
        }
        return -1;
    }
}
