import java.lang.reflect.Array;
import java.util.Arrays;

public class Q4ReconstructBinTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        // 1,2,4,7,3,5,6,8
        // 4,7,2,1,5,3,8,6
        if (pre == null || in == null || pre.length != in.length || pre.length == 0){
            return null;
        }

        //find root
        int rootValue = pre[0];
        //split pre and in according to root index
        int rootIndex = 0;
        while (rootIndex < in.length){
            if (in[rootIndex] == rootValue){
                break;
            }else {
                rootIndex += 1;
            }
        }

        int[] lPre = Arrays.copyOfRange(pre, 1, 1+rootIndex);
        int[] rPre = Arrays.copyOfRange(pre, 1+rootIndex, pre.length);
        int[] lIn = Arrays.copyOfRange(in, 0, rootIndex);
        int[] rIn = Arrays.copyOfRange(in, rootIndex+1, in.length);

        TreeNode lNode = reConstructBinaryTree(lPre, lIn);
        TreeNode rNode = reConstructBinaryTree(rPre, rIn);
        TreeNode root = new TreeNode(rootValue);
        root.left = lNode;
        root.right = rNode;
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree(pre, in);
        int a = 1;
    }
}
