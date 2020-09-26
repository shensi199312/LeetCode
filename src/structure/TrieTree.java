package structure;

import java.util.List;

/**
 * Trie树
 */
public class TrieTree {

    private int trieMaxCharNum;

    private TrieNode root;

    public class TrieNode
    {
        public TrieNode[] child;
        public boolean isEnd;

        public TrieNode(int trieMaxCharNum, boolean isEnd) {
            child = new TrieNode[trieMaxCharNum];
            this.isEnd = isEnd;
        }
    }

    public TrieTree(int trieMaxCharNum)
    {
        this.trieMaxCharNum = trieMaxCharNum;
        root = new TrieNode(trieMaxCharNum, false);
        root.isEnd = false;
    }

    public void insert(String str)
    {
        char[] chars = str.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < chars.length; i++) {
            int c = chars[i];
            TrieNode node = cur.child[c];
            if (node == null)
            {
                node = new TrieNode(trieMaxCharNum, i == chars.length - 1);
                cur.child[c] = node;
            }
            cur = node;
        }
    }

    public boolean search(String str)
    {
        TrieNode cur = root;
        int i = 0;
        while (i < str.length())
        {
            int c = str.charAt(i);
            if (cur.child[c] == null)
            {
                return false;
            }
            i++;
            cur = cur.child[c];
        }
        return cur.isEnd;
    }

    public void preOrder()
    {
        preOrderRecur(root, 0);
    }

    private void preOrderRecur(TrieNode node, int layer)
    {
        if (node != null)
        {
            TrieNode[] child = node.child;
            for (int i = 0; i < child.length; i++) {
                TrieNode c = child[i];
                if (c != null)
                {
                    System.out.println((char)('a' + i));
                    preOrderRecur(c, layer + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        TrieTree tree = new TrieTree(128);
        tree.insert("abc");
        tree.insert("edgf");
        tree.insert("hgh");

        System.out.println((char)('a' + 1));
        tree.preOrder();
    }
}
