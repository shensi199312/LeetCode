import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文串
 */
public class _409 {
    public int longestPalindrome(String s) {
        int[] dic = new int[128];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            dic[c]++;
        }
        int count = 0;
        for (int i = 0; i < dic.length; i++) {
            if (dic[i] % 2 == 0)
            {
                count += dic[i];
            }else {
                count += (dic[i] / 2) * 2;
            }

        }
        return count < s.length() ? count + 1 : count;
    }
}
