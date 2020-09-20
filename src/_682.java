import java.util.Stack;

/**
 * 棒球比赛
 */
public class _682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i])
            {
                case "+":
                    Integer n1 = stack.pop();
                    Integer n2 = stack.pop();
                    stack.push(n2);
                    stack.push(n1);
                    sum += (n1 + n2);
                    stack.push(n1 + n2);
                    break;
                case "D":
                    Integer n3 = stack.pop();
                    sum += n3 * 2;
                    stack.push(n3);
                    stack.push(n3 * 2);
                    break;
                case "C":
                    Integer n4 = stack.pop();
                    sum -= n4;
                    break;
                default:
                    int n5 = Integer.parseInt(ops[i]);
                    sum += n5;
                    stack.push(n5);
                    break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        _682 v = new _682();
        int i = v.calPoints(new String[]{"5", "2", "C", "D", "+"});
        System.out.println(i);
    }
}
