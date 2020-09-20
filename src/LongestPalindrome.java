
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

    public String longestPalindrome(String s) {
        int n = s.length();
        if (s.length() == 0)
        {
            return "";
        }
        int[][] r = new int[n][n];
        for (int i = 0; i < r.length; i++) {
            r[i][i] = 1;
        }
        int[][] l = new int[n][n];

        for (int step = 2; step <= n; step++) {
            for (int i = 0; i < n - step + 1;i++)
            {
                int j = i + step - 1;
                if (s.charAt(i) == s.charAt(j) && j - i - 1 == r[i + 1][j - 1])
                {
                    r[i][j] = r[i + 1][j - 1] + 2;
                    l[i][j] = i;
                }
                else if (r[i + 1][j] >= r[i][j - 1])
                {
                    r[i][j] = r[i + 1][j];
                    l[i][j] = l[i + 1][j];
                }
                else {
                    r[i][j] = r[i][j - 1];
                    l[i][j] = l[i][j - 1];
                }
            }
        }
        int len = r[0][s.length() - 1];
        int i = l[0][s.length() - 1];
        return s.substring(i, i + len);
    }



    public static void main(String[] args) {
        LongestPalindrome palindrome = new LongestPalindrome();
        String babad = palindrome._longestPalindrome("ac");
        System.out.println(babad);
    }
}
