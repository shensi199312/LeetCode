
/**
 * 最长回文子串
 */
public class LongestPalindrome {

    /**
     * 改进
     * @param s
     * @return
     */
    public String _longestPalindrome(String s)
    {
        if (s.length() <= 1)
        {
            return s;
        }

        int maxLen = 1;
        int beginIdx = 0;
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j))
                {
                    dp[i][j] = false;
                }else {
                    if (j - i < 3)
                    {
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen)
                {
                    beginIdx = i;
                    maxLen = j - i + 1;
                }
            }
        }

        return s.substring(beginIdx, beginIdx + maxLen);
    }



    public static void main(String[] args) {
        LongestPalindrome palindrome = new LongestPalindrome();
        String babad = palindrome._longestPalindrome("ac");
        System.out.println(babad);
    }
}
