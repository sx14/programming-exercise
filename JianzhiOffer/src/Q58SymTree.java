public class Q58SymTree {
    //  判断一颗二叉树是不是对称的。
    //  注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        else return isSame(pRoot.left, pRoot.right);
    }

    boolean isSame(TreeNode n1, TreeNode n2){
        if (n1 == null && n2 == null) return true;
        else if (n1 != null && n2 == null) return false;
        else if (n1 == null && n2 != null) return false;

        if (n1.val == n2.val) {
            return isSame(n1.left, n2.right) && isSame(n1.right, n2.left);
        } else {
            return false;
        }
    }
}
