import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现栈
 * 思路:使用临时队列变换数据
 */
public class _225 {
    class MyStack {

        private Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            Queue<Integer> tmp = new LinkedList<>();
            tmp.add(x);
            while (!queue.isEmpty())
            {
                tmp.add(queue.poll());
            }
            queue = tmp;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.remove();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
