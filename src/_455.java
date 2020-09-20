/**
 * 分发饼干
 * 思路：
 * 1.先排序
 * 2.用小的饼干优先满足需求小的孩子
 */
public class _455 {

    public int findContentChildren(int[] g, int[] s) {
        sort(g, 0, g.length - 1);
        sort(s, 0, s.length - 1);
        int m = 0;
        int n = 0;
        while (m < g.length && n < s.length)
        {
            if (s[n] >= g[m])
            {
                m++;
            }
            n++;

        }
        return m;
    }


    public void sort(int[] array, int p, int r)
    {
        if (p < r)
        {
            int q = partition(array, p, r);
            sort(array, p, q - 1);
            sort(array, q + 1, r);
        }
    }

    public int partition(int[] array, int p, int r)
    {
        int i = p - 1;
        int key = array[r];
        for (int j = p; j <= r - 1; j++) {
            if (array[j] < key)
            {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, ++i, r);
        return i;
    }

    private void swap(int[] array, int a, int b)
    {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
