import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
 */
public class _138 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        Node dummy = new Node(0);

        // 维护原链表节点与对应的拷贝节点的映射
        Map<Node,Node> resultMap = new HashMap<>();

        Node r = dummy;
        while (head != null)
        {
            Node random = head.random;
            Node next = head.next;

            Node _cur = resultMap.containsKey(head) ? resultMap.get(head) : new Node(head.val);
            resultMap.put(head, _cur);

            Node _random = null;
            if (random != null)
            {
                _random = resultMap.containsKey(random) ? resultMap.get(random) : new Node(random.val);
                resultMap.put(random, _random);
            }

            Node _next = null;
            if (next != null)
            {
                _next = resultMap.containsKey(next) ? resultMap.get(next) : new Node(next.val);
                resultMap.put(next, _next);
            }

            _cur.next = _next;
            _cur.random = _random;

            resultMap.put(head, _cur);

            r.next = _cur;
            r = r.next;
            head = head.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node _7 = new Node(7);
        Node _13 = new Node(13);
        Node _0 = new Node(0);
        Node _11 = new Node(11);
        Node _4 = new Node(4);
        Node _10 = new Node(10);
        Node _2 = new Node(2);
        Node _1 = new Node(1);

        _7.next = _13;

        _13.next = _11;
        _13.random = _0;

        _11.next = _10;
        _11.random = _4;

        _10.next = _1;
        _10.random = _2;

        _1.random = _0;

//        Node __1 = new Node(-1);
        // Node _0 = new Node(0);

//        __1.random = __1;

        Node node = copyRandomList(_7);

        System.out.println(node);
    }
}
