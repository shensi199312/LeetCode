/**
 * 3.无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
        {
            return 0;
        }
        if (s.length() <= 1)
        {
            return s.length();
        }

        String tmp = s.substring(0, 1);
        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            if (tmp.contains(s.charAt(i) + ""))
            {
                tmp = tmp.substring(tmp.indexOf(s.charAt(i)) + 1) + s.charAt(i);
            }else {
                tmp += (s.charAt(i) + "");
            }

            if (tmp.length() > maxLen)
            {
                maxLen = tmp.length();
            }
        }

        return maxLen;
    }
}
