import java.util.HashMap;

/**
 * LRU
 */
public class _146 {

    class Node{
        public int key;
        public int val;
        public Node prev;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class LRUCache {

        private int maxCapacity;

        public Node head,tail;

        public HashMap<Integer,Node> map = new HashMap<>();

        public LRUCache(int capacity) {
            maxCapacity = capacity;

            head = new Node(0, -1);
            tail = new Node(0, -1);

            head.next = tail;
            tail.prev = head;
        }

        private void addToHead(Node node)
        {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(Node node)
        {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private Node getTail()
        {
            return tail.prev;
        }


        public int get(int key) {
            Node node = map.get(key);
            if (node == null)
            {
                return -1;
            }else {
                removeNode(node);
                addToHead(node);
                return node.val;
            }
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node == null)
            {
                node = new Node(key, value);
                map.put(key, node);
                addToHead(node);
                if (map.size() > maxCapacity)
                {
                    Node tail = getTail();
                    removeNode(tail);
                    map.remove(tail.key);
                }
            }else {
                node.val = value;
                removeNode(node);
                addToHead(node);
            }
        }
    }
}
