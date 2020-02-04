import sun.reflect.generics.tree.Tree;

public class Q17SubTree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


    private static boolean checkNow(TreeNode root1, TreeNode root2){
        // 就地检查
        if (root2 == null){
            return true;
        }else {
            if (root1 == null){
                return false;
            }else {
                // 两棵树都不为空时：要求值相等且左右子树相同
                return root1.val == root2.val && checkNow(root1.left, root2.left) && checkNow(root1.right, root2.right);
            }
        }
    }


    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }else {
            // 首先就地检查（checkNow）
            // 若就地检查不成功，则向更深处检查（向左子树、向右子树）
            return checkNow(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
    }


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(-1);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(3);
        root1.left.left.left = new TreeNode(4);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(4);

        System.out.println(HasSubtree(root1, root2));
    }
}
