/**
 * 计算给定二叉树的所有左叶子之和。
 */
public class _404 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            return recur(root, 0);
        }

        public int recur(TreeNode root, int sum)
        {
            if (root != null)
            {
                // 计算左子树左叶子之和
                TreeNode left = root.left;
                if (left != null)
                {
                    if (left.left != null || left.right != null)
                    {
                        sum = recur(left, sum);
                    }else
                    {
                        sum = sum + left.val;
                    }
                }

                // 计算右子树左叶子之和
                TreeNode right = root.right;
                if (right != null)
                {
                    if (right.left != null || right.right != null)
                    {
                        return recur(right, sum);
                    }
                }
            }
            return sum;
        }
    }
  

  
}
