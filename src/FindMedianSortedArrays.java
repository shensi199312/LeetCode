/**
 * 寻找两个有序数组的中位数
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        int k1 = 0, k2 = 0;

        int m = (l1 + l2) / 2;
        int m1 = 0,m2 = 0;

        for (int i = 0; i <= m; i++) {
            int cur;
            if (k2 > l2 - 1)
            {
                cur = nums1[k1];
                k1++;
            }else if (k1 > l1 - 1)
            {
                cur = nums2[k2];
                k2++;
            }else if (nums1[k1] <= nums2[k2]){
                cur = nums1[k1];
                k1++;
            }else {
                cur = nums2[k2];
                k2++;
            }

            if (i == m - 1)
            {
                m1 = cur;
            }
            if (i == m)
            {
                m2 = cur;
            }
        }

        return (l1 + l2) % 2 == 0 ? (double) (m1 + m2) / 2 : m2;
    }
}
