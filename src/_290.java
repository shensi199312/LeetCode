import java.util.HashMap;
import java.util.Map;

/**
 * 单词规律
 */
public class _290 {
    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] strs = s.split(" ");

        if (strs.length != chars.length)
        {
            return false;
        }

        Map<String,Character> map = new HashMap<>();
        String used = "";


        for (int i = 0; i < strs.length; i++) {
            char c = chars[i];
            String world = strs[i];

            Character p = map.get(world);
            if (p == null)
            {
                if (used.contains(c + ""))
                {
                    return false;
                }else {
                    map.put(world, c);
                    used += c;
                }
            }else {
                if (p != c)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _290 v = new _290();
        boolean b = v.wordPattern("abba", "dog cat cat fish");
        System.out.println(b);
    }
}
