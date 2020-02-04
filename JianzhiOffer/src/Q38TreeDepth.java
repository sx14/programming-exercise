public class Q38TreeDepth {

     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
         this.val = val;

         }
     }

    public int TreeDepth(TreeNode root) {
         if (root == null){
             return 0;
         }

         int ldepth = TreeDepth(root.left);
         int rdepth = TreeDepth(root.right);
         return (ldepth > rdepth ? ldepth: rdepth) + 1;
    }
}
