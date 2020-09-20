import java.util.Stack;

/**
 * 移掉k位数字
 * 思路：使用栈保证的每一位都是当前位的最小值
 */
public class _402 {

    public String removeKdigits(String num, int k) {
        if (k == 0)
        {
            return num;
        }
        if (k == num.length())
        {
            return "0";
        }
        char[] chars = num.toCharArray();
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.valueOf(chars[0] + ""));
        for (int i = 1; i < chars.length; i++) {
            Integer val = Integer.valueOf(chars[i] + "");
            while (k > 0 && !stack.isEmpty() && val < stack.peek())
            {
                stack.pop();
                k--;
            }
            // 处理数字首部为0
            if(!stack.isEmpty() || val != 0)
            {
                stack.push(val);
            }

        }

        while (k > 0 && !stack.isEmpty())
        {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty())
        {
            result.insert(0, stack.pop());
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        _402 v = new _402();
        String s = v.removeKdigits("1432219", 3);
        System.out.println(s);
    }
}
