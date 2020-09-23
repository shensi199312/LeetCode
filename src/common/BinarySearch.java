package common;

public class BinarySearch {

    public int search(int[] array, int val)
    {
        int p = 0;
        int r = array.length - 1;

        while (p <= r)
        {
            int mid = (p + r) / 2;
            if (array[mid] == val)
            {
                return mid;
            }
            else if (array[mid] > val)
            {
                r = mid - 1;
            }
            else {
                p = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int search = binarySearch.search(new int[]{1, 3, 4, 7, 9, 12, 23, 56}, 56);
        System.out.println(search);
    }
}
