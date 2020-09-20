/**
 * 翻转字符串
 */
public class _344 {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2 - 1; i++) {
            swap(s, i, s.length - i - 1);
        }
    }

    public void swap(char[] s, int a, int b)
    {
        char tmp = s[a];
        s[a] = s[b];
        s[b] = tmp;
    }
}
