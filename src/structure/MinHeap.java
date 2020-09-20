package structure;

public class MinHeap {

    private int[] array;

    private int heapSize;

    public MinHeap(int[] array)
    {
        this.array = array;
        buildHeap();
    }

    private void buildHeap()
    {
        heapSize = array.length;
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            minHeapify(i);
        }
    }

    public int peek()
    {
        if (heapSize > 0)
        {
            return array[0];
        }
        throw new RuntimeException("max heap is empty");
    }

    public int pop()
    {
        if (heapSize > 0)
        {
            int min = array[0];
            swap(array, 0, heapSize - 1);
            heapSize--;
            minHeapify(0);
            return min;
        }
        throw new RuntimeException("max heap under flow");
    }

    public void decrease(int i, int val)
    {
        if (i > heapSize - 1)
        {
            throw new RuntimeException("target index larger than heap size");
        }
        if (array[i] < val)
        {
            throw new RuntimeException("decrease val must smaller than before");
        }
        while (i > 0 && array[parent(i)] > val)
        {
            array[i] = array[parent(i)];
            i = parent(i);
        }
        array[i] = val;
    }

    public void push(int val)
    {
        int[] copy = new int[array.length + 1];
        System.arraycopy(array, 0, copy, 0, heapSize);
        copy[heapSize] = Integer.MAX_VALUE;
        array = copy;
        heapSize++;
        decrease(heapSize - 1, val);
    }

    public int size()
    {
        return heapSize;
    }

    private void minHeapify(int i)
    {
        int val = array[i];
        int l = left(i);
        int r = right(i);
        int smallestVal = val;
        int smallestIdx = i;

        if (l < heapSize && array[l] < smallestVal)
        {
            smallestIdx = l;
            smallestVal = array[l];
        }

        if (r < heapSize && array[r] < smallestVal)
        {
            smallestIdx = r;
        }

        if (smallestIdx != i)
        {
            swap(array, i, smallestIdx);
            minHeapify(smallestIdx);
        }
    }

    private int parent(int i)
    {
        return (i + 1) / 2 - 1;
    }

    private int left(int i)
    {
        return 2 * i + 1;
    }

    private int right(int i)
    {
        return 2 * i + 2;
    }

    private void swap(int[] array, int a, int b)
    {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(new int[]{3,4,5,6,9,12,11,7});
        System.out.println(minHeap.peek());
        minHeap.push(13);
        System.out.println(minHeap.peek());
        System.out.println(minHeap.pop());
        System.out.println(minHeap.pop());
        System.out.println(minHeap.pop());
        System.out.println(minHeap.pop());
        System.out.println(minHeap.pop());
        System.out.println(minHeap.pop());
        System.out.println(minHeap.pop());
        System.out.println(minHeap.pop());
        System.out.println(minHeap.pop());
        System.out.println(minHeap.size());
    }
}
