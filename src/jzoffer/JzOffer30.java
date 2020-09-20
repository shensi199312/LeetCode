package jzoffer;

import java.util.Stack;

/**
 * 包含最小值的栈
 * 思路:额外维护一个最小值栈
 */
public class JzOffer30 {

    class MinStack {

        Stack<Integer> stack, minValStack;

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
                Integer min = minValStack.peek();
                minValStack.push(x < min ? x : min);
            }
        }
        public void pop() {
            stack.pop();
            minValStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minValStack.peek();
        }
    }

}
