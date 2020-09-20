package common;

public class MergeSort {

    public void mergeSort(int[] nums)
    {
        sort(nums, 0, nums.length - 1);
    }


    public void sort(int[] nums, int p, int r)
    {
        if (p < r)
        {
            int mid = (p + r) / 2;
            sort(nums, p, mid);
            sort(nums, mid + 1, r);
            merge(nums, p, mid, r);
        }
    }

    public void merge(int[] nums, int p, int q, int r)
    {
        int[] nums1 = new int[q - p + 1];
        int[] nums2 = new int[r - q];
        System.arraycopy(nums, p, nums1, 0, q - p + 1);
        System.arraycopy(nums, q + 1, nums2, 0, r - q);

        int m = 0;
        int n = 0;
        for (int i = 0; i < r - p + 1; i++) {
            if (m > nums1.length - 1)
            {
                nums[p + i] = nums2[n];
                n++;
            }else if (n > nums2.length - 1)
            {
                nums[p + i] = nums1[m];
                m++;
            }else if (nums1[m] < nums2[n])
            {
                nums[p + i] = nums1[m];
                m++;
            }else {
                nums[p + i] = nums2[n];
                n++;
            }
        }
    }

    public static void main(String[] args) {
        int[] in = {3, 2, 5, 7, 8, 1, 9};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(in);
        System.out.println(in);
    }
}
