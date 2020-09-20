import structure.MaxHeap;
import structure.MinHeap;

/**
 * 寻找数组中第k大数
 * 1.最小堆
 * 2.快速排序思路
 */
public class _215 {

    static class Solution {

        public int findKthLargest(int[] nums, int k) {
            int[] array = new int[k];
            for (int i = 0; i < k; i++) {
                array[i] = nums[i];
            }
            MinHeap minHeap = new MinHeap(array);
            for (int i = k; i < nums.length;i++){
                if (nums[i] >= minHeap.peek())
                {
                    minHeap.pop();
                    minHeap.push(nums[i]);
                }
            }
            return minHeap.peek();
        }

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.findKthLargest(new int[]{2,3,4,5,66,7,8,434,32}, 4));
        System.out.println(solution.findKthLargest(new int[]{-1,2,0}, 2));
    }
}
