/**
 * 链表反转
 */
public class _206 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode prev = null;
            while(cur != null)
            {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
    }
}
