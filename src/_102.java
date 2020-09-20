import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 */
public class _102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
        {
            queue.add(root);
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty())
        {
            List<Integer> level = new ArrayList<>();
            Queue<TreeNode> tmp = new LinkedList<>();
            while (!queue.isEmpty())
            {
                TreeNode poll = queue.poll();
                level.add(poll.val);
                if (poll.left != null)
                {
                    tmp.add(poll.left);
                }
                if (poll.right != null)
                {
                    tmp.add(poll.right);
                }
            }
            result.add(level);
            queue = tmp;
        }
        return result;
    }
}
