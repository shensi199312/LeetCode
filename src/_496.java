import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 下一个更大元素 I
 * 思路:维护一个从栈顶到栈底递增的单调栈
 */
public class _496 {

    public int[] _nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && stack.peek() < nums2[i])
            {
                Integer pop = stack.pop();
                map.put(pop, nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            Integer val = map.get(nums1[i]);
            result[i] = val == null ? -1 : val;
        }
        return result;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = -1;
            int val = nums1[i];
            boolean find = false;
            for (int j = 0;j < nums2.length;j++)
            {
                if (find && nums2[j] > val)
                {
                    result[i] = nums2[j];
                    break;
                }
                if (nums2[j] == val)
                {
                    find = true;
                }
            }

        }
        return result;
    }


}
