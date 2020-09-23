import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 计算右侧小于当前元素的个数
 * 2.变种二叉搜素树(记录值比当前节点小的节点数目)思路
 */
public class _315_ {

    public class TreeNode
    {
        public int val;
        public int count;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0)
        {
            return list;
        }
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        int[] result = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            TreeNode node = new TreeNode(nums[i]);
            result[i] = insertAndCount(root, node);
        }
        for (int i = 0; i < result.length; i++) {
            list.add(result[i]);
        }
        return list;
    }

    private int insertAndCount(TreeNode root, TreeNode node)
    {
        int count = 0;
        TreeNode p = null;
        TreeNode cur = root;
        while (cur != null)
        {
            p = cur;
            if (node.val <= cur.val)
            {
                cur.count += 1; // 节点本身count+1
                cur = cur.left;
            }else {
                count += (cur.count + 1); // 当前节点左子树所有节点之和+1
                cur = cur.right;

            }
        }
        if (p == null)
        {
            return 0;
        }else {
            if (node.val <= p.val)
            {
                p.left = node;
            }else {
                p.right = node;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        _315_ v = new _315_();
        List<Integer> integers = v.countSmaller(new int[]{5, 2, 6, 1});
        System.out.println(integers);
    }
}
