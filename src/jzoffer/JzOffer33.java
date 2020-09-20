package jzoffer;

public class JzOffer33 {

    public boolean verifyPostorder(int[] postorder) {
        int[] tree = new int[3];
        int j = 0;
        for (int i = 0; i < postorder.length; i++) {
            tree[j] = postorder[i];
            if (j == 2)
            {
                if (tree[0] <= tree[2] && tree[2] <= tree[1])
                {
                    j = 0;
                    tree[j] = postorder[i];
                }else {
                    return false;
                }
            }
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        JzOffer33 jzOffer33 = new JzOffer33();
        boolean b = jzOffer33.verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10});
        System.out.println(b);


    }
}
