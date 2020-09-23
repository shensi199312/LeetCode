import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字母异位词分组
 * 1.对每个字符串进行排序后存放在map中进行分类
 * 2.计算每个字符串基于26个字母的位图,以位图作为map的key进行分类
 */
public class _49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            String sort = sort(str);
            List<String> list = map.getOrDefault(sort, new ArrayList<>());
            list.add(str);
            map.put(sort, list);
        }

        return new ArrayList<>(map.values());
    }

    private String sort(String str)
    {
        char[] chars = str.toCharArray();
        sort(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void sort(char[] chars, int p, int r)
    {
        if (p < r)
        {
            int q = partition(chars, p, r);
            sort(chars, p, q - 1);
            sort(chars, q + 1, r);
        }
    }

    private int partition(char[] chars, int p, int r)
    {
        int i = p - 1;
        char key = chars[r];
        for (int j = p; j <= r - 1; j++) {
            if (chars[j] < key)
            {
                i++;
                swap(chars, i, j);
            }
        }
        swap(chars, ++i, r);
        return i;
    }

    private void swap(char[] chars, int a, int b){
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }
}
