import java.util.ArrayList;
import java.util.List;

/**
 * 计算右侧小于当前元素的个数
 * 1.归并排序思路
 */
public class _315 {

    public class Pair
    {
        public int idx;
        public int val;
        public int count;

        public Pair(int idx, int val, int count) {
            this.idx = idx;
            this.val = val;
            this.count = count;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            result.add(null);
        }
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            pairs.add(new Pair(i, nums[i], 0));
        }
        sort(pairs, 0, nums.length - 1);
        for (Pair pair : pairs) {
            result.set(pair.idx, pair.count);
        }
        return result;
    }

    public void sort(List<Pair> pairs, int p, int r)
    {
        if (p < r)
        {
            int mid = (p + r) / 2;
            sort(pairs, p, mid);
            sort(pairs, mid + 1, r);
            merge(pairs, p, mid, r);
        }
    }

    public void merge(List<Pair> pairs, int p, int q, int r)
    {
        List<Pair> p1 = new ArrayList<>();
        List<Pair> p2 = new ArrayList<>();

        for (int i = p; i <= q; i++) {
            p1.add(pairs.get(i));
        }

        for (int i = q + 1; i <= r; i++) {
            p2.add(pairs.get(i));
        }

        int m = 0;
        int n = 0;

        for (int i = 0; i < r - p + 1; i++) {
            if (m > p1.size() - 1)
            {
                pairs.set(p + i, p2.get(n));
                n++;
            }
            else if (n > p2.size() - 1)
            {
                Pair pair = p1.get(m);
                pair.count += n;
                pairs.set(p + i, pair);
                m++;
            }
            else if (p1.get(m).val <= p2.get(n).val)
            {
                Pair pair = p1.get(m);
                pair.count += n;
                pairs.set(p + i, pair);
                m++;
            }
            else {
                pairs.set(p + i, p2.get(n));
                n++;
            }
        }
    }


}
