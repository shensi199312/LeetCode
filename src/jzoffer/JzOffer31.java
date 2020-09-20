package jzoffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class JzOffer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < popped.length; i++) {
            queue.add(popped[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek().equals(queue.peek()))
            {
                stack.pop();
                queue.poll();
            }
        }
        return stack.isEmpty();
    }
}
