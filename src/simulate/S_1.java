package simulate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 全排列
 */
public class S_1 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> cur = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            cur.add(null);
        }
        generate(0, nums, cur, set);
        return new ArrayList<>(set);
    }

    public void generate(int i, int[] nums, List<Integer> cur, Set<List<Integer>> set)
    {
        if (i > nums.length - 1)
        {
            set.add(cur);
            return;
        }

        int ni = cur.get(i) == null ? nums[i] : cur.get(i);

        for (int j = i;j < nums.length;j++)
        {
            List<Integer> copy = new ArrayList<>(cur);

            int nj = copy.get(j) == null ? nums[j] : copy.get(j);

            if (i != j)
            {
                copy.set(j, ni);
            }
            copy.set(i, nj);

            generate(i + 1, nums, copy, set);
        }
    }
}
