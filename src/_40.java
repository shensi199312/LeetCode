import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> items = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        sort(candidates, 0, candidates.length - 1);
        result.add(items);
        generateSubset(0, candidates, set, items, result, 0, target);


        List<List<Integer>> sumResult = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            int sum = 0;
            for (int i1 = 0; i1 < result.get(i).size(); i1++) {
                sum += result.get(i).get(i1);
            }
            if (sum == target)
            {
                sumResult.add(result.get(i));
            }
        }

        return sumResult;
    }

    public void generateSubset(int i,
                               int[] nums,
                               Set<List<Integer>> set,
                               List<Integer> items,
                               List<List<Integer>> result,
                               int sum,
                               int target)
    {
        if (i >= nums.length || sum > target)
        {
            return;
        }
        sum += nums[i];
        items.add(nums[i]);
        List<Integer> copy = new ArrayList<>();
        for (Integer item : items) {
            copy.add(item);
        }
        if (!set.contains(copy) && target == sum)
        {
            set.add(copy);
            result.add(copy);
        }
        generateSubset(i + 1, nums, set, items, result, sum, target);
        sum -= nums[i];
        items.remove((Object)nums[i]);
        generateSubset(i + 1, nums, set, items, result, sum, target);

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
