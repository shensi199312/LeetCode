import sun.tools.java.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 重复的DNA序列
 *
 * 方法1：暴力枚举
 * 方法2：
 * 低位在前,高位在后
 * 每遍历一位,右移动2位,新数字左移动18位
 */
public class _187 {


    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sequence = s.substring(i, i + 10);
            Integer count = map.getOrDefault(sequence, 0);
            map.put(sequence, ++count);
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > 1)
            {
                result.add(e.getKey());
            }
        }
        return result;
    }

    public List<String> _findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();

        if (s.length() <= 10)
        {
            return result;
        }

        Map<Integer,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int cur = map(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            int data = map(chars[i]);
            if (i < 10)
            {
                cur |= (data << (i * 2));
            }else {
                cur = (cur >> 2) | (data << 18); // 高位在后,低位在前
            }

            if (i >= 9)
            {
                Integer count = map.getOrDefault(cur, 0);
                map.put(cur, ++count);
            }
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > 1)
            {
                Integer key = e.getKey();
                StringBuilder sequence = new StringBuilder();
                while (key != 0)
                {
                    sequence.append(map(key % 4));
                    key = key >> 2;
                }
                while (sequence.length() < 10)
                {
                    sequence.append('A');
                }
                result.add(sequence.toString());
            }
        }
        return result;
    }

    private int map(char c)
    {
        switch (c)
        {
            case 'C':
                return 0x01;
            case 'G':
                return 0x10;
            case 'T':
                return 0x11;
            default:
                return 0x00;
        }
    }

    private char map(int i)
    {
        switch (i)
        {
            case 0x01:
                return 'C';
            case 0x10:
                return 'G';
            case 0x11:
                return 'T';
            default:
                return 'A';
        }
    }

    public static void main(String[] args) {
        _187 v = new _187();
        List<String> s = v._findRepeatedDnaSequences("GAGAGAGAGAGA");
        System.out.println(s);
    }

}
