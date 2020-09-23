import java.util.ArrayList;
import java.util.List;

/**
 * 跟节点到叶子节点的路径和
 */
public class _113 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        recur(root, sum, 0, cur, result);
        return result;
    }

    public void recur(TreeNode root, int target, int sum, List<Integer> cur, List<List<Integer>> result)
    {
        if (root != null)
        {
            sum += root.val;
            cur.add(root.val);
            if (sum == target && root.left == null && root.right == null){
                result.add(cur);
            }
            List<Integer> c1 = new ArrayList<>(cur);
            recur(root.left, target, sum, c1, result);
            List<Integer> c2 = new ArrayList<>(cur);
            recur(root.right, target, sum, c2, result);
        }
    }
}
