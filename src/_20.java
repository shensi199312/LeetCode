import java.util.Stack;

/**
 * 有效括号
 */
public class _20 {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                switch (c)
                {
                    case '(':
                        stack.push('(');
                        break;
                    case ')':
                        if (!stack.isEmpty() && stack.peek() == '(')
                        {
                            stack.pop();
                        }else{
                            stack.push(')');
                        }
                        break;
                    case '{':
                        stack.push('{');
                        break;
                    case '}':
                        if (!stack.isEmpty() && stack.peek() == '{')
                        {
                            stack.pop();
                        }else{
                            stack.push('}');
                        }
                        break;
                    case '[':
                        stack.push('[');
                        break;
                    case ']':
                        if (!stack.isEmpty() && stack.peek() == '[')
                        {
                            stack.pop();
                        }else{
                            stack.push(']');
                        }
                        break;
                }
            }
            return stack.isEmpty();
        }
    }
}
