public class Q39AVLTree {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public int isBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lDepth = isBalanced(root.left);
        int rDepth = isBalanced(root.right);

        if (lDepth == -1 || rDepth == -1){
            return -1;
        }

        int depthMin = lDepth < rDepth ? lDepth : rDepth;
        int depthMax = lDepth > rDepth ? lDepth : rDepth;
        if (depthMax - depthMin <= 1){
            return depthMax + 1;
        }else {
            return -1;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return isBalanced(root) != -1;
    }
}
