import java.util.List;

/**
 * 三角形最小路径和
 * 思路:自低向上递推
 */
public class _120 {

    //状态转移方程:dp[i][j] = min(dp[i+1][j],dp[i+1][j+1]) + triangle[i][j]
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
        {
            return 0;
        }
        else if (triangle.size() == 1)
        {
            int min = Integer.MAX_VALUE;
            List<Integer> list = triangle.get(0);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) <= min)
                {
                    min = list.get(i);
                }
            }
            return min;
        }else {
            List<Integer> lastLevel = triangle.get(triangle.size() - 1);
            int rows = triangle.size();
            int columns = lastLevel.size();
            int[][] dp = new int[rows][columns];
            for (int i = 0; i < lastLevel.size(); i++) {
                dp[rows - 1][i] = lastLevel.get(i);
            }
            for (int i = rows - 2;i >= 0;i--)
            {
                List<Integer> level = triangle.get(i);
                for (int j = 0; j < level.size(); j++) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + level.get(j);
                }
            }
            return dp[0][0];
        }
    }
}
