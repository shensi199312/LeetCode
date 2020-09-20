import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历
 */
public class _94 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty())
            {
                TreeNode peek = stack.peek();
                while (peek != null)
                {
                    stack.push(peek.left);
                    peek = stack.peek();
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
}
