/**
 * 建立四叉树
 */
public class _427 {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) { // n = 2 ^ x and r = c
        int r = grid.length;
        if (r == 0)
        {
            return null;
        }
        int c = grid[0].length;
        Node root = new Node();
        recur(grid, 0, c - 1, 0, r - 1, root);
        return root;
    }

    public void recur(int[][] grid,
                      int xStart,
                      int xEnd,
                      int yStart,
                      int yEnd,
                      Node parent)
    {
        if (xStart < xEnd)
        {
            int xMid = (xStart + xEnd) / 2;
            int yMid = (yStart + yEnd) / 2;

            // top left
            Node tl = new Node();
            recur(grid, xStart, xMid, yStart, yMid, tl);

            // top right
            Node tr = new Node();
            recur(grid, xMid + 1, xEnd, yStart, yMid, tr);

            // bottom left
            Node bl = new Node();
            recur(grid, xStart, xMid, yMid + 1, yEnd, bl);

            // bottom right
            Node br = new Node();
            recur(grid, xMid + 1, xEnd, yMid + 1, yEnd, br);

            if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf &&
                tl.val ==  tr.val &&  tr.val == bl.val && bl.val == br.val){
                parent.isLeaf = true;
                parent.val = tl.val;
            }else {
                parent.topLeft = tl;
                parent.topRight = tr;
                parent.bottomLeft = bl;
                parent.bottomRight = br;
            }
        }else {
            parent.isLeaf = true;
            parent.val = grid[yStart][xStart] == 1;
        }
    }


    public static void main(String[] args) {
        _427 v = new _427();
        Node root = v.construct(new int[][]{
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0}
        });
        System.out.println(root);
    }
}
