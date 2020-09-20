/**
 * 链表划分
 */
public class _86 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode s = smallDummy;
        ListNode largeDummy = new ListNode(0);
        ListNode l = largeDummy;
        while (head != null)
        {
            if (head.val < x)
            {
                s.next = head;
                s = s.next;
            }else {
                l.next = head;
                l = l.next;
            }
            head = head.next;
        }
        l.next = null;
        s.next = largeDummy.next;
        return smallDummy.next;
    }

    public static void main(String[] args) {
        ListNode _1 = new ListNode(1);
        ListNode _4 = new ListNode(4);
        ListNode _3 = new ListNode(3);
        ListNode _2 = new ListNode(2);
        ListNode _5 = new ListNode(5);
        ListNode __2 = new ListNode(2);
        _1.next = _4;
        _4.next = _3;
        _3.next = _2;
        _2.next = _5;
        _5.next = __2;

        ListNode partition = partition(_1, 3);
        System.out.println(partition);
    }
}
