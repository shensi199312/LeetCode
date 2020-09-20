/**
 * 反转字符串中的元音字母
 */
public class _345 {

    public String reverseVowels(String s) {

        String aeiou = "aeiouAEIOU";

        char[] chars = s.toCharArray();

        int i = 0; int j = s.length() - 1;
        while (i < j)
        {
            if (aeiou.contains(s.charAt(i) + "") && aeiou.contains(s.charAt(j) + ""))
            {
                swap(chars, i, j);
                i++;
                j--;
                continue;
            }
            if (!aeiou.contains(s.charAt(i) + ""))
            {
                i++;
            }
            if (!aeiou.contains(s.charAt(j)+ ""))
            {
                j--;
            }
        }
        return new String(chars);
    }

    public void swap(char[] s, int a, int b)
    {


        char tmp = s[a];
        s[a] = s[b];
        s[b] = tmp;
    }
}
