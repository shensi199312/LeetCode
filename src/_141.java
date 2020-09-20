import java.util.HashSet;
import java.util.Set;

/**
 * 链表存在环
 */
public class _141 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while (head != null)
            {
                if (set.contains(head))
                {
                    return true;
                }
                set.add(head);
                head = head.next;
            }
            return false;
        }

        /**
         * 快慢指针
         * @param head
         * @return
         */
        public boolean _hasCycle(ListNode head) {
            ListNode s = head;
            ListNode f = head;

            while (f != null)
            {
                s = s.next;
                f = f.next;
                if(f == null)
                {
                    return false;
                }else{
                    f = f.next;
                }

                if (f == s)
                {
                    return true;
                }
            }

            return false;
        }
    }
}
