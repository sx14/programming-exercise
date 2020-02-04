public class Q18MirrorTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public void Mirror(TreeNode root) {
        if (root != null){
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            Mirror(left);
            Mirror(right);
        }
    }
}
