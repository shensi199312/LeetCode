import java.util.ArrayList;
import java.util.List;

/**
 * N皇后
 */
public class _51 {

    private static final int[] dx = new int[]{-1,1,0,0,1,-1,1,-1};
    private static final int[] dy = new int[]{0,0,1,-1,1,1,-1,-1};

    public List<List<String>> solveNQueens(int n) {
        List<String> location = new ArrayList<>();
        int[][] mark = new int[n][n];
        List<List<String>> result = new ArrayList<>();
        recur(0, n, location, mark, result);
        return result;
    }

    /**
     *
     * @param k 已完成k行皇后设置
     * @param n
     * @param location
     * @param mark
     * @param result
     */
    public void recur(int k,
                      int n,
                      List<String> location,
                      int[][] mark,
                      List<List<String>> result)
    {
        if (k == n)
        {
            result.add(location);
            return;
        }
        for (int i = 0; i < n; i++) { // 对每列进行皇后设置的尝试
            if (mark[k][i] == 0) // 该位置未被其他皇后攻击
            {
                int[][] markCopy = copyMark(mark);
                ArrayList<String> locationCopy = new ArrayList<>(location);
                location.add(createLocationStr(n, i));
                putQueen(mark, k, i);
                recur(k + 1, n, location, mark, result);
                // 回溯到当前列未设置皇后的状态
                mark = markCopy;
                location = locationCopy;
            }
        }
    }

    private void putQueen(int[][] mark, int m, int n)
    {
        mark[m][n] = 1;
        for (int i = 1; i < mark.length; i++) { // 步长
            for (int j = 0; j < 8; j++) { // 八个方向
                int _x = m + dx[j] * i;
                int _y = n + dy[j] * i;
                if (_x >= 0 && _x <= mark.length - 1 &&
                    _y >= 0 && _y <= mark.length - 1){
                    mark[_x][_y] = 1;
                }
            }
        }
    }

    private int[][] copyMark(int[][] mark)
    {
        int[][] copy = new int[mark.length][mark.length];

        for (int i = 0; i < mark.length; i++) {
            for (int j = 0; j < mark.length; j++) {
                copy[i][j] = mark[i][j];
            }
        }

        return copy;
    }

    private String createLocationStr(int n, int k)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i == k ? "Q" : ".");
        }
        return sb.toString();
    }
}
