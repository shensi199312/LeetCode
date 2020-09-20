import java.util.HashSet;
import java.util.Set;

/**
 * 链表存在环
 */
public class _142 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            ListNode meet = null;

            while (fast != null)
            {
                fast = fast.next;
                slow = slow.next;

                if (fast == null)
                {
                    return null;
                }
                fast = fast.next;

                if (fast == slow)
                {
                    meet = fast;
                    break;
                }
            }

            if (meet == null)
            {
                return null;
            }

            while (meet != null && head != null)
            {
                if (meet == head)
                {
                    return head;
                }
                meet = meet.next;
                head = head.next;
            }

            return null;
        }
    }
}
