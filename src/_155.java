import java.util.Stack;

public class _155 {
    class MinStack {

        public Stack<Integer> stack;
        public Stack<Integer> minValStack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minValStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minValStack.isEmpty())
            {
                minValStack.push(x);
            }else {
                minValStack.push(x < minValStack.peek() ? x : minValStack.peek());
            }
        }

        public void pop() {
            if (!stack.isEmpty())
            {
                stack.pop();
                minValStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minValStack.peek();
        }
    }
}
