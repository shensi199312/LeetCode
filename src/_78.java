import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 */
public class _78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> items = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(items);
        generateSubset(0, nums, items, result);
        return result;
    }

    public void generateSubset(int i, int[] nums, List<Integer> items, List<List<Integer>> result)
    {
        if (i >= nums.length)
        {
            return;
        }

        items.add(nums[i]);

        List<Integer> copy = new ArrayList<>();
        for (int j = 0; j < items.size(); j++) {
            copy.add(items.get(j));
        }

        result.add(copy);
        generateSubset(i + 1, nums, items, result);
        // 回溯,不添加nums[i]的情况
        items.remove((Object)nums[i]);
        generateSubset(i + 1, nums, items, result);
    }

    // 位运算法
    public List<List<Integer>> _subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int allSet = 1 << nums.length;
        for (int i = 0; i < allSet; i++) {// 遍历全集
            List<Integer> items = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) { // 遍历每一位
                int k = 1 << (nums.length - j - 1);
                if ((i & k) == k) // 当前位存在,将当前位对应的数添加到items
                {
                    items.add(nums[j]);
                }
            }
            result.add(items);
        }
        return result;
    }

    public static void main(String[] args) {
        _78 v = new _78();
        List<List<Integer>> subsets = v.subsets(new int[]{1, 2, 3, 4});
        System.out.println(subsets);
    }
}
