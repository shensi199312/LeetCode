import structure.MaxHeap;
import structure.MinHeap;

/**
 * 数据流中位数
 */
public class _295 {
    static class MedianFinder {

        private MinHeap minHeap;
        private MaxHeap maxHeap;

        /** initialize your data structure here. */
        public MedianFinder() {

        }

        public void addNum(int num) {
            if (minHeap == null)
            {
                minHeap = new MinHeap(new int[]{num});
            }
            else if (maxHeap == null)
            {
                if (num > minHeap.peek())
                {
                    minHeap.push(num);
                    num = minHeap.pop();
                }
                maxHeap = new MaxHeap(new int[]{num});
            }
            else if (minHeap.size() == maxHeap.size())
            {
                if (num > minHeap.peek())
                {
                    minHeap.push(num);
                }else {
                    maxHeap.push(num);
                }
            }
            else if (minHeap.size() > maxHeap.size())
            {
                if (num > minHeap.peek())
                {
                    int pop = minHeap.pop();
                    maxHeap.push(pop);
                    minHeap.push(num);
                }else {
                    maxHeap.push(num);
                }
            }
            else
            {
                if (num > maxHeap.peek())
                {
                    minHeap.push(num);
                }else {
                    int pop = maxHeap.pop();
                    maxHeap.push(num);
                    minHeap.push(pop);
                }
            }
        }

        public double findMedian() {
            if (maxHeap == null)
            {
                return minHeap.peek();
            }

            if (minHeap.size() == maxHeap.size())
            {
                return (double) (minHeap.peek() + maxHeap.peek()) / 2;
            }else {
                return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
            }
        }
    }

    public static void main(String[] args) {

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(12);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(13);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(11);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(15);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(11);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(17);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(14);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(8);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(17);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(16);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(8);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(12);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
    }
}
