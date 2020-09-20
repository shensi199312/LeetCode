import structure.MaxHeap;

import java.util.*;

/**
 * 合并k个升序链表
 */
public class _23 {

    public static class MinHeap<T> {

        private List<T> data;

        private int heapSize;

        private Comparator<T> comparator;

        public MinHeap(List<T> list, Comparator<T> comparator)
        {
            this.data = list;
            this.comparator = comparator;
            buildHeap();
        }


        private void buildHeap()
        {
            heapSize = data.size();
            for (int i = data.size() / 2 - 1; i >= 0; i--) {
                minHeapify(i);
            }
        }

        public T peek()
        {
            if (heapSize > 0)
            {
                return data.get(0);
            }
            throw new RuntimeException("max heap is empty");
        }

        public T pop()
        {
            if (heapSize > 0)
            {
                T max = data.get(0);
                swap(0, heapSize - 1);
                heapSize--;
                minHeapify(0);
                return max;
            }
            throw new RuntimeException("max heap under flow");
        }

        public void decrease(int i, T val)
        {
            if (i > heapSize - 1)
            {
                throw new RuntimeException("target index larger than heap size");
            }
            if (comparator.compare(data.get(i), val) < 0)
            {
                throw new RuntimeException("increase val must smaller than before");
            }
            while (i > 0 && comparator.compare(data.get(parent(i)), val) > 0)
            {
                data.set(i, data.get(parent(i)));
                i = parent(i);
            }
            data.set(i, val);
        }

        public void push(T val)
        {
            data.set(heapSize, val);
            heapSize++;
            decrease(heapSize - 1, val);
        }

        public int size()
        {
            return heapSize;
        }

        private void minHeapify(int i)
        {
            T val = data.get(i);
            int l = left(i);
            int r = right(i);
            T smallestVal = val;
            int smallestIdx = i;

            if (l < heapSize && comparator.compare(data.get(l), smallestVal) < 0)
            {
                smallestIdx = l;
                smallestVal = data.get(l);
            }

            if (r < heapSize && comparator.compare(data.get(r), smallestVal) < 0)
            {
                smallestIdx = r;
            }

            if (smallestIdx != i)
            {
                swap(i, smallestIdx);
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

        private void swap(int a, int b)
        {
            T tmp = data.get(a);
            data.set(a, data.get(b));
            data.set(b, tmp);
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            List<ListNode> in = new ArrayList<>();
            for (ListNode l : lists) {
                if (l != null)
                {
                    in.add(l);
                }
            }
            if (in.size() == 0)
            {
                return null;
            }

            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            MinHeap<ListNode> minHeap = new MinHeap<>(in, Comparator.comparingInt(l -> l.val));
            while (minHeap.size() > 0)
            {
                ListNode pop = minHeap.pop();
                cur.next = pop;
                if (pop.next != null)
                {
                    minHeap.push(pop.next);
                }
                cur = cur.next;
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode[] in = new ListNode[3];

        ListNode l1 = new ListNode(1);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l4;
        l4.next = l5;
        in[0] = l1;

        ListNode l1_ = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4_ = new ListNode(4);
        l1_.next = l3;
        l3.next = l4_;
        in[1] = l1_;

        ListNode l2 = new ListNode(2);
        ListNode l6 = new ListNode(6);
        l2.next = l6;
        in[2] = l2;

        ListNode listNode = solution.mergeKLists(in);
        System.out.println(listNode);
    }
}
