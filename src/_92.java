/**
 * 反转链表制定范围
 */
public class _92 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            int idx = 1;
            ListNode cur = head;
            // 逆置段头节点
            ListNode prev = null;

            // 逆置段前驱节点
            ListNode reversePrev = null;
            // 逆置段尾节点
            ListNode reverseTail = head;

            while (cur != null && idx <= n)
            {
                ListNode next = cur.next;

                if (idx == m)
                {
                    reversePrev = prev;
                    reverseTail = cur;
                }
                else if (idx > m && idx <= n)
                {
                    cur.next = prev;
                }
                prev = cur;
                cur = next;
                idx++;
            }
            // 逆置段尾节点链接当前节点
            reverseTail.next = cur;

            if (reversePrev != null)
            {
                // 逆置段前驱不为空,前驱节点链接逆置段
                reversePrev.next = prev;
            }else {
                return prev;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
//        ListNode _4 = new ListNode(4);
//        ListNode _5 = new ListNode(5);
//
        _1.next = _2;
        _2.next = _3;
//        simulate._3.next = _4;
//        _4.next = _5;

        Solution solution = new Solution();
        ListNode r = solution.reverseBetween(_1, 1, 2);
        System.out.println(r);
    }
}
