import java.util.Stack;

public class CQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty())
        {
            while (!stack1.isEmpty())
            {
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
        }
        return stack2.isEmpty() ?  -1: stack2.pop();
    }
}
