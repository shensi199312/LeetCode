package jzoffer;

import java.util.*;

/**
 * 字符串的排列
 */
public class JzOffer38 {
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        List<Character> cur = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            cur.add(null);
        }
        Set<String> set = new HashSet<>();
        generate(0, chars, cur, set);
        String[] result = new String[set.size()];
        Iterator<String> iterator = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            result[i] = iterator.next();
        }
        return result;
    }

    private void generate(int k, char[] chars, List<Character> cur, Set<String> set){
        if (k == chars.length - 1)
        {
            if (cur.get(k) == null)
            {
                cur.set(k, chars[k]);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cur.size(); i++) {
                sb.append(cur.get(i));
            }
            set.add(sb.toString());
            return;
        }

        Character c = cur.get(k) == null ? chars[k] : cur.get(k);
        for (int i = k; i < chars.length; i++) {
            List<Character> copy = new ArrayList<>(cur);
            Character ci = copy.get(i) == null ? chars[i] : copy.get(i);
            copy.set(k, ci);
            copy.set(i, c);
            generate(k + 1, chars, copy, set);
        }
    }
}
