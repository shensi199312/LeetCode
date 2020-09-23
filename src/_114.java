/**
 * 二叉树展开为链表
 * 思路:找到左子树的最右节点作为右子树的前驱,并将当前节点的左子树赋值为null,前驱节点的右子树设置为当前节点的右子树
 */
public class _114 {

    public static class TreeNode {
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

    public void _flatten(TreeNode root){
        TreeNode cur = root;
        while (cur != null)
        {

            TreeNode left = cur.left;
            TreeNode right = cur.right;

            if (left != null)
            {
                TreeNode successor = left;
                while (successor.right != null)
                {
                    successor = successor.right;
                }
                successor.right = right;
                cur.left = null;
                cur.right = left;
            }

            cur = cur.right;
        }
    }

    public void flatten(TreeNode root) {
        recur(root);
    }

    private TreeNode recur(TreeNode node)
    {
        if (node == null)
        {
            return null;
        }
        if (node.left == null && node.right == null)
        {
            return node;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;
        TreeNode leftLast = null;
        TreeNode rightLast = null;

        if (left != null)
        {
            leftLast = recur(left);
            node.left = null;
            node.right = left;
        }

        if (right != null)
        {
            rightLast = recur(right);
            if (leftLast != null)
            {
                leftLast.right = right;
            }
        }

        return rightLast;
    }

    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        TreeNode _4 = new TreeNode(4);
        TreeNode _5 = new TreeNode(5);


        _1.left = _2;
        _1.right = _4;
        _2.right = _3;
        _4.left = _5;

        _114 v = new _114();
        v.flatten(_1);
        System.out.println();
    }
}
