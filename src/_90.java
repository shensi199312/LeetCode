import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 子集 II(包含重复元素的整数数组)
 * 思路:1.先排序 2.对子集做去重
 */
public class _90 {


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> items = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        sort(nums, 0, nums.length - 1);
        result.add(items);
        generateSubset(0, nums, set, items, result);
        return result;
    }

    public void generateSubset(int i, int[] nums, Set<List<Integer>> set, List<Integer> items, List<List<Integer>> result)
    {
        if (i >= nums.length)
        {
            return;
        }

        items.add(nums[i]);
        List<Integer> copy = new ArrayList<>();
        for (Integer item : items) {
            copy.add(item);
        }
        if (!set.contains(copy))
        {
            set.add(copy);
            result.add(copy);
        }
        generateSubset(i + 1, nums, set, items, result);
        items.remove((Object)nums[i]);
        generateSubset(i + 1, nums, set, items, result);

    }


    public void sort(int[] array, int p, int r)
    {
        if (p < r)
        {
            int q = partition(array, p, r);
            sort(array, p, q - 1);
            sort(array, q + 1, r);
        }
    }

    public int partition(int[] array, int p, int r)
    {
        int i = p - 1;
        int key = array[r];
        for (int j = p; j <= r - 1; j++) {
            if (array[j] < key)
            {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, ++i, r);
        return i;
    }

    private void swap(int[] array, int a, int b)
    {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
