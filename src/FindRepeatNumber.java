import javax.swing.tree.TreeNode;
import java.util.*;

public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int[] c = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (c[nums[i]] > 0)
            {
                return nums[i];
            }
            c[nums[i]]++;
        }
        return -1;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for(int i = 0;i < matrix.length;i++)
        {
            for(int j = 0; j < matrix[i].length;j++)
            {
                if (matrix[i][j] == target)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        int len = 0;
        while (cur != null)
        {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            len++;
        }
        int[] result = new int[len];
        int idx = 0;
        while (prev != null)
        {
            result[idx] = prev.val;
            prev = prev.next;
            idx++;
        }
        return result;
    }

    public static int fib(int n) {

        if(n == 0)
        {
            return 0;
        }

        if(n == 1)
        {
            return 1;
        }

        int[] r = new int[n + 1];
        r[0] = 0;
        r[1] = 1;
        for(int i = 2;i <= n;i++)
        {
            r[i] = r[i - 1] + r[i - 2];
        }
        return r[n];
    }

    public static int _fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
//        int fib = _fib(45);
//        System.out.println(fib);

//        System.out.println(numWays(7));

//        int i = cuttingRope(10);

//        int i = hammingWeight(11);
        double v = myPow(2.0000d, -2);
        System.out.println(v);
    }

    public static int numWays(int n) {
        if (n == 0)
        {
            return 1;
        }
        if (n == 1)
        {
            return 1;
        }

        int[] r = new int[n + 1];
        r[0] = 0;
        r[1] = 1;
        r[2] = 2;
        for (int i = 3; i <= n;i++)
        {
            r[i] = r[i - 1] + r[i - 2];
        }
        return r[n];
    }

    public static int cuttingRope(int n) {
        int[] c = new int[n + 1];
        c[0] = 0;
        c[1] = 1;
        for(int i = 2;i <= n;i++)
        {
            int max = 0;
            for(int j = 1;j < i;j++)
            {
                int other = Math.max(c[i - j], (i - j));
                int cur = Math.max(c[j], j);
                int p = cur * other;
                if(p > max)
                {
                    max = p;
                    c[i] = p;
                }
            }
        }
        return c[n];
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0)
        {
            if(n == 1)
            {
                count++;
                break;
            }
            if(n % 2 != 0)
            {
                count++;
            }
            n /= 2;
        }
        return count;
    }


    public static double myPow(double x, int n) {
        if (n == 0)
        {
            return 1;
        }
        long b = n; // 防止越界
        double res = 1.0d;
        if (n < 0)
        {
            b = -b;
            x = 1 / x;
        }
        while (b != 0)
        {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0; i < pushed.length;i++)
        {
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == pushed[j])
            {
                stack.pop();
                j++;
            }
        }


        return stack.empty();
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int[] levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode treeNode = queue.removeFirst();
            if (treeNode != null)
            {
                result.add(treeNode.val);
                if(treeNode.left != null)
                {
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null)
                {
                    queue.add(treeNode.right);
                }
            }

        }

        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    public List<List<Integer>> _levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) { queue.add(root); }
        while (!queue.isEmpty())
        {
            List<Integer> level = new ArrayList<>();
            Queue<TreeNode> tmp = new ArrayDeque<>();
            while (!queue.isEmpty())
            {
                TreeNode poll = queue.poll();
                level.add(poll.val);
                if (poll.left != null)
                {
                    tmp.offer(poll.left);
                }
                if (poll.right != null)
                {
                    tmp.offer(poll.right);
                }
            }
            result.add(level);
            queue = tmp;
        }
        return result;
    }

    public List<List<Integer>> _levelOrder_(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) { queue.add(root); }
        while (!queue.isEmpty())
        {
            List<Integer> level = new ArrayList<>();
            Queue<TreeNode> tmp = new ArrayDeque<>();
            while (!queue.isEmpty())
            {
                TreeNode poll = queue.poll();
                level.add(poll.val);
                if (poll.left != null)
                {
                    tmp.offer(poll.left);
                }
                if (poll.right != null)
                {
                    tmp.offer(poll.right);
                }
            }
            result.add(level);
            queue = tmp;
        }
        return result;
    }

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        int left = 0;
        int right = 0;
        int curLeft = 0;
        int curRight = 0;

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            curRight = i;
            if (sum >= 0)
            {
                sum += nums[i];
            }else
            {
                curLeft = i;
                sum = nums[i];
            }
            if (sum > maxSum)
            {
                maxSum = sum;
                left = curLeft;
                right = curRight;
            }
        }
        return maxSum;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        int q = recur(arr, 0, arr.length - 1, k);
        for (int i = 0; i <= q; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public int recur(int[] arr, int p, int r, int k)
    {
        if (p < r)
        {
            int q = partition(arr, p, r);
            if (q == k)
            {
                return q;
            }else if (q > k)
            {
                return recur(arr, p, q - 1, k);
            }else {
                return recur(arr, q + 1, r, k - q - 1);
            }
        }
        return p;
    }

    public int partition(int[] arr, int p, int r)
    {
        int x = arr[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (arr[j] < x)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, ++i, r);
        return i;
    }

    public void swap(int[] arr, int a, int b)
    {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public char firstUniqChar(String s) {
        LinkedHashMap<Character,Integer> linkedHashMap = new LinkedHashMap();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = s.charAt(i);
            Integer count = linkedHashMap.getOrDefault(c, 0);
            linkedHashMap.put(c, ++count);
        }
        char result = ' ';
        for (Map.Entry<Character, Integer> e : linkedHashMap.entrySet()) {
            if (e.getValue() == 1)
            {
                result = e.getKey();
                break;
            }
        }
        return result;
    }


    public int maxDepth(TreeNode root) {
        int h = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null)
        {
            queue.add(root);
        }

        while (!queue.isEmpty())
        {
            Queue<TreeNode> tmp = new ArrayDeque<>();
            while (!queue.isEmpty())
            {
                TreeNode poll = queue.poll();
                if (poll.left != null)
                {
                    tmp.add(poll.left);
                }
                if (poll.right != null)
                {
                    tmp.add(poll.right);
                }
            }
            queue = tmp;
            h++;
        }
        return h;
    }
}
