import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 * 思路：滑动窗口(双指针)
 */
public class _76 {

    public String minWindow(String s, String t) {

        Map<Character,Integer> requireMap = new HashMap<>();
        char[] tchars = t.toCharArray();
        for (int i = 0; i < tchars.length; i++) {
            Integer count = requireMap.getOrDefault(tchars[i], 0);
            requireMap.put(tchars[i], ++count);
        }

        int p = 0;
        int minBegin = 0;
        int minEnd = 0;
        int minLen = Integer.MAX_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            Integer count = map.getOrDefault(c, 0);
            map.put(c, ++count);


            while (p < chars.length && (!requireMap.containsKey(chars[p]) || requireMap.getOrDefault(chars[p], 0) < map.getOrDefault(chars[p], 0)))
            {
                Integer beginCharCount = map.getOrDefault(chars[p], 0);
                map.put(chars[p], --beginCharCount);
                p++;
            }

            if (checkComplete(requireMap, map) && i - p + 1 < minLen)
            {
                minLen = i - p + 1;
                minBegin = p;
                minEnd = i;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minBegin, minEnd + 1);
    }

    private boolean checkComplete(Map<Character,Integer> requiredMap, Map<Character,Integer> map)
    {
        for (Map.Entry<Character, Integer> e : requiredMap.entrySet()) {
            Character key = e.getKey();
            Integer val = map.getOrDefault(key, 0);
            if (e.getValue() > val)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _76 v = new _76();
        String s = v.minWindow("a", "b");
        System.out.println(s);
    }
}
