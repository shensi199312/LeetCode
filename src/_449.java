import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 序列化和反序列化二叉搜索树
 * 思路:按先序遍历序列化,反序列化则是按序读取然后插入二叉树
 */
public class _449 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public String _serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        preOrder(root, result);
        return result.toString();
    }

    public void preOrder(TreeNode node, StringBuilder sb)
    {
        if (node != null)
        {
            sb.append(node.val + "#");
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }
    }

    public TreeNode _deserialize(String data) {
        if (data == null || data.length() == 0)
        {
            return null;
        }
        String[] split = data.split("#");
        if (split.length != 0)
        {
            String s = split[0];
            TreeNode root = new TreeNode(Integer.parseInt(s));
            for (int i = 1; i < split.length; i++) {
                if (split[i].length() != 0)
                {
                    TreeNode node = new TreeNode(Integer.parseInt(split[i]));
                    insert(root, node);
                }
            }
            return root;
        }else {
            return null;
        }
    }

    private void insert(TreeNode root, TreeNode node)
    {
        TreeNode p = null;
        TreeNode cur = root;
        while (cur != null)
        {
            p = cur;
            if (node.val <= cur.val)
            {
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        if (p != null)
        {
            if (node.val <= p.val)
            {
                p.left = node;
            }else {
                p.right = node;
            }
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            Queue<TreeNode> tmp = new LinkedList<>();
            boolean allNull = true;
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                if (poll == null)
                {
                    sb.append("N");
                    tmp.offer(null);
                    tmp.offer(null);
                }else {
                    sb.append(poll.val);
                    if (poll.left != null || poll.right != null)
                    {
                        allNull = false;
                    }
                    tmp.offer(poll.left);
                    tmp.offer(poll.right);
                }
                if (queue.size() > 0)
                {
                    sb.append("-");
                }
            }
            if (!allNull){
                queue = tmp;
            }
            if (queue.size() > 0){
                sb.append("|");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split("\\|");
        if (split.length == 0)
        {
            return null;
        }else {
            String s = split[0];
            if (!"N".equals(s))
            {
                TreeNode root = new TreeNode(Integer.parseInt(s));
                List<TreeNode> curLevel = new ArrayList<>();
                curLevel.add(root);
                for (int i = 1;i < split.length;i++)
                {
                    String[] nodes = split[i].split("-");
                    List<TreeNode> nextLevel = new ArrayList<>();
                    for (int j = 0; j < nodes.length; j++) {
                        String val = nodes[j];
                        TreeNode node = "N".equals(val) ? null : new TreeNode(Integer.parseInt(val));
                        nextLevel.add(node);
                    }
                    levelSet(curLevel, nextLevel);
                    curLevel = nextLevel;
                }
                return root;
            }else {
                return null;
            }
        }
    }

    private void levelSet(List<TreeNode> curLevel, List<TreeNode> nextLevel)
    {
        for (int i = 0; i < curLevel.size(); i++) {
            TreeNode treeNode = curLevel.get(i);
            if (treeNode != null)
            {
                treeNode.left = nextLevel.get(2 * i);
                treeNode.right = nextLevel.get(2 * i + 1);
            }
        }
    }

    public static void main(String[] args) {
        _449 codec = new _449();


        TreeNode _5 = new TreeNode(5);
        TreeNode _2 = new TreeNode(2);
        TreeNode _7 = new TreeNode(7);
        TreeNode _1 = new TreeNode(1);
        TreeNode _3 = new TreeNode(3);
        TreeNode _6 = new TreeNode(6);
        TreeNode _9 = new TreeNode(9);
        TreeNode _4 = new TreeNode(4);
        TreeNode _8 = new TreeNode(8);

        _5.left = _2;
        _5.right = _7;
        _2.left = _1;
        _2.right = _3;
        _7.left = _6;
        _7.right = _9;
        _3.right = _4;
        _9.left = _8;

        String serialize = codec._serialize(_5);
        System.out.println(serialize);

        TreeNode deserialize = codec._deserialize(serialize);
        System.out.println(deserialize);
    }
}
