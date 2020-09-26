import java.util.ArrayList;
import java.util.List;

/**
 * 成绩比较: aa 100(语) 90(数) 80(外)
 * 总分大的在前,总分相同比语文,语文相同比数学
 */
public class Test {

    public void sort(List<String> in)
    {
        String[][] strs = new String[in.size()][];
        for (int i = 0; i < in.size(); i++) {
            String s = in.get(i);
            String[] split = s.split(" ");
            strs[i] = split;
        }

        sort(strs, 0, strs.length - 1);
        for (int i = 0; i < strs.length; i++) {
            String[] str = strs[i];
            System.out.println(str[0] + " " + str[1] + " " + str[2] + " " + str[3]);
        }
    }

    private void sort(String[][] strs, int p, int r)
    {
        if (p < r)
        {
            int q = partition(strs, p, r);
            sort(strs, p, q - 1);
            sort(strs, q + 1, r);
        }
    }

    private int partition(String[][] strs, int p, int r)
    {
        int i = p - 1;
        int keyY = Integer.parseInt(strs[r][1]);
        int keyS = Integer.parseInt(strs[r][2]);
        int keyW = Integer.parseInt(strs[r][3]);
        int key = keyY + keyS + keyW;

        for (int j = p; j <= r - 1; j++) {
            int y = Integer.parseInt(strs[j][1]);
            int s = Integer.parseInt(strs[j][2]);
            int w = Integer.parseInt(strs[j][3]);

            int score = y + s + w;
            if (score < key || (score == key && y < keyY) || (score == key && y == keyY && s < keyS))
            {
                i++;
                swap(strs, i, j);
            }
        }
        swap(strs, ++i, r);
        return i;
    }

    private void swap(String[][] strs, int a, int b)
    {
        String[] tmp = strs[a];
        strs[a] = strs[b];
        strs[b] = tmp;
    }

    public static void main(String[] args) {
        Test test = new Test();
        ArrayList<String> in = new ArrayList<>();
        in.add("a 90 20 10"); // 120
        in.add("b 90 50 10");  // 150
        in.add("c 70 40 40");  // 150
        in.add("d 60 70 10");  // 140
        in.add("e 60 40 40");  // 140
        test.sort(in);
    }
}
