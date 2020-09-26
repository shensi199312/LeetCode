import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 字典序排序并组成的全排列
 * 思路:先求全排列,再字典排序,还要去重
 */
public class Test2 {

    public List<List<String>> solution(String[] sts)
    {
        List<String> cur = new ArrayList<>();
        for (int i = 0; i < sts.length; i++) {
            cur.add(null);
        }
        Set<List<String>> set = new HashSet<>();
        // 求全排列
        generate(0, sts, cur, set);

        // 对全排列进行字典排序
        ArrayList<List<String>> result = new ArrayList<>(set);
        sort(result, 0, result.size() - 1);
        return result;
    }

    private void sort(List<List<String>> result, int p, int r)
    {
        if (p < r)
        {
            int q = partition(result, p, r);
            sort(result, p, q - 1);
            sort(result, q + 1, r);
        }
    }

    private int partition(List<List<String>> result, int p, int r)
    {
        int i = p - 1;
        String key = result.get(r).get(0);
        for (int j = p; j <= r - 1; j++) {
            String s = result.get(j).get(0);
            boolean isSmall;
            int len = Math.min(s.length(), key.length());
            int k = 0;
            while (k < len && s.charAt(k) == key.charAt(k))
            {
                k++;
            }
            if (k < len)
            {
                isSmall = s.charAt(k) < key.charAt(k);
            }else {
                isSmall = s.length() < key.length();
            }
            if (isSmall)
            {
                i++;
                swap(result, i, j);
            }
        }
        swap(result, ++i, r);
        return i;
    }

    private void swap(List<List<String>> result, int a, int b)
    {
        List<String> tmp = result.get(a);
        result.set(a, result.get(b));
        result.set(b, tmp);
    }


    private void generate(int k, String[] strs, List<String> cur, Set<List<String>> set)
    {
        if (k == strs.length - 1)
        {
            if (cur.get(k) == null)
            {
                cur.set(k, strs[k]);
            }
            set.add(cur);
            return;
        }

        String s = cur.get(k) == null ? strs[k] : cur.get(k);
        for (int i = k; i < strs.length; i++) {
            List<String> copy = new ArrayList<>(cur);
            String t = copy.get(i) == null ? strs[i] : copy.get(i);
            if (i != k)
            {
                copy.set(i, s);
            }
            copy.set(k, t);
            generate(k + 1, strs, copy, set);
        }
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        List<List<String>> solution = test2.solution(new String[]{"ab", "ab", "bc",
//                "ab", "eca", "bcd", "ef", "ac"
        }
                );
        System.out.println(solution);
    }

}
