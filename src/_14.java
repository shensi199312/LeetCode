/**
 * 最长公共前缀
 */
public class _14 {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if (strs.length > 0)
        {
            int i = 0;
            while (true)
            {
                if (i > strs[0].length() - 1)
                {
                    return result.toString();
                }
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i > strs[j].length() - 1 || strs[j].charAt(i) != c){
                        return result.toString();
                    }
                }
                result.append(c);
                i++;
            }
        }
        return result.toString();
    }
}
