import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * 思路:双指针滑动窗口
 */
public class _3 {

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        char[] chars = s.toCharArray();
        int p = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            Integer idx = map.get(c);
            if (idx != null && idx >= p)
            {
                p = idx + 1;
            }
            map.put(c, i);
            int len = i - p + 1;
            if (len > maxLen)
            {
                maxLen = len;
            }
        }
        return maxLen;
    }
}
