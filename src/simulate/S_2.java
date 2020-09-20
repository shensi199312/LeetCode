package simulate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 */
public class S_2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recur(root, result);
        return result;
    }

    public void recur(TreeNode root, List<Integer> result) {
        if (root != null)
        {
            recur(root.left, result);
            result.add(root.val);
            recur(root.right, result);
        }
    }


    public List<Integer> _inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            while (stack.peek() != null)
            {
                TreeNode peek = stack.peek();
                stack.push(peek.left);
            }
            stack.pop();
            if (!stack.isEmpty())
            {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                stack.push(pop.right);
            }
        }
        return result;
    }
}
