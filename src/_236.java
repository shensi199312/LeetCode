import java.util.LinkedList;

/**
 * 二叉树的最近公共祖先
 */
public class _236 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> l1 = new LinkedList<>();
        preOrder(root, p, l1);
        LinkedList<TreeNode> l2 = new LinkedList<>();
        preOrder(root, q, l2);

        while (l1.peekLast() != l2.peekLast())
        {
            if (l1.size() > l2.size())
            {
                l1.pollLast();
            }
            else if (l1.size() < l2.size())
            {
                l2.pollLast();
            }
            else {
                l1.pollLast();
                l2.pollLast();
            }
        }
        return l1.isEmpty() ? null : l1.peekLast();
    }

    private void preOrder(TreeNode root, TreeNode search, final LinkedList<TreeNode> list)
    {
        if (root == null)
        {
            return;
        }
        list.add(root);
        if (root == search)
        {
            return;
        }
        if (root.left != null){
            preOrder(root.left, search, list);
        }
        if (root.right != null && list.peekLast() != search)
        {
            list.remove(root.left);
            preOrder(root.right, search, list);
        }
    }

    public static void main(String[] args) {
        TreeNode _3 = new TreeNode(3);
        TreeNode _5 = new TreeNode(5);
        TreeNode _1 = new TreeNode(1);
        TreeNode _6 = new TreeNode(6);
        TreeNode _2 = new TreeNode(2);
        TreeNode _0 = new TreeNode(0);
        TreeNode _8 = new TreeNode(8);
        TreeNode _7 = new TreeNode(7);
        TreeNode _4 = new TreeNode(4);

        _3.left = _5;
        _3.right = _1;

        _5.left = _6;
        _5.right = _2;

        _1.left = _0;
        _1.right = _8;

        _2.left = _7;
        _2.right = _4;

        _236 v = new _236();
        TreeNode treeNode = v.lowestCommonAncestor(_3, _5, _4);
        System.out.println(treeNode);
    }
}
