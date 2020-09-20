package structure;

public class MaxHeap {

    private int[] array;

    private int heapSize;

    public MaxHeap() {
    }

    public MaxHeap(int[] array)
    {
        this.array = array;
        buildHeap();
    }

    private void buildHeap()
    {
        heapSize = array.length;
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
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
            int max = array[0];
            swap(array, 0, heapSize - 1);
            heapSize--;
            maxHeapify(0);
            return max;
        }
        throw new RuntimeException("max heap under flow");
    }

    public void increase(int i, int val)
    {
        if (i > heapSize - 1)
        {
            throw new RuntimeException("target index larger than heap size");
        }
        if (array[i] > val)
        {
            throw new RuntimeException("increase val must larger than before");
        }
        while (i > 0 && array[parent(i)] < val)
        {
            array[i] = array[parent(i)];
            i = parent(i);
        }
        array[i] = val;
    }

    public void push(int val)
    {
        if (array == null)
        {
            array = new int[]{val};
            buildHeap();
            return;
        }
        int[] copy = new int[array.length + 1];
        System.arraycopy(array, 0, copy, 0, heapSize);
        copy[heapSize] = Integer.MIN_VALUE;
        array = copy;
        heapSize++;
        increase(heapSize - 1, val);
    }

    public int size()
    {
        return heapSize;
    }

    private void maxHeapify(int i)
    {
        int val = array[i];
        int l = left(i);
        int r = right(i);
        int largestVal = val;
        int largestIdx = i;

        if (l < heapSize && array[l] > largestVal)
        {
            largestIdx = l;
            largestVal = array[l];
        }

        if (r < heapSize && array[r] > largestVal)
        {
            largestIdx = r;
        }

        if (largestIdx != i)
        {
            swap(array, i, largestIdx);
            maxHeapify(largestIdx);
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
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.push(3);
        maxHeap.push(4);
        maxHeap.push(7);
        System.out.println(maxHeap.peek());
    }
}
