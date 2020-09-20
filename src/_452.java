/**
 * 用最少数量的箭引爆气球
 */
public class _452 {

    public int findMinArrowShots(int[][] points) {

        if (points.length < 2)
        {
            return points.length;
        }

        sort(points, 0, points.length - 1);
        int s = Integer.MIN_VALUE;
        int e = Integer.MAX_VALUE;
        int count = 1;
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            if (p[0] <= e)
            {
                s = Math.max(s, p[0]);
                e = Math.min(e, p[1]);
            }else {
                s = p[0];
                e = p[1];
                count++;
            }
        }
        return count;
    }

    public void sort(int[][] points, int p, int r)
    {
        if (p < r){
            int q = partition(points, p, r);
            sort(points, p, q - 1);
            sort(points, q + 1, r);
        }
    }

    private int partition(int[][] points, int p, int r)
    {
        int i = p - 1;
        int key = points[r][0];
        for (int j = p; j <= r - 1; j++) {
            if (points[j][0] < key)
            {
                i++;
                swap(points, i, j);
            }
        }
        swap(points, ++i, r);
        return i;
    }

    public void swap(int[][] points, int a, int b)
    {
        int[] tmp = points[a];
        points[a] = points[b];
        points[b] = tmp;
    }

    public static void main(String[] args) {
        int[][] in = new int[][]{
                new int[]{1,2},
                new int[]{3,4},
                new int[]{5,6},
                new int[]{7,8}
        };
        _452 v = new _452();
        int minArrowShots = v.findMinArrowShots(in);
        System.out.println(minArrowShots);
    }
}
