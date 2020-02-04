import java.util.ArrayList;

public class Q62SearchTree {

// 给定一棵二叉搜索树，
// 请找出其中的第k小的结点。
// 例如， （5，3，7，2，4，6，8）中，
// 按结点数值大小顺序第三小结点的值为4。

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    private static ArrayList<TreeNode> midSort(TreeNode root){
        assert root != null;

        ArrayList<TreeNode> result = new ArrayList<>();
        if (root.left != null){
            ArrayList<TreeNode> leftSub = midSort(root.left);
            result.addAll(leftSub);
        }

        result.add(root);

        if (root.right != null){
            ArrayList<TreeNode> rightSub = midSort(root.right);
            result.addAll(rightSub);
        }
        return result;
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 1) return null;

        ArrayList<TreeNode> sortedNodes = midSort(pRoot);
        if (k > sortedNodes.size()) return null;
        else return sortedNodes.get(k-1);
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(5);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(7);
        n0.left = n1;
        n0.right = n2;
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        n1.left = n3;
        n1.right = n4;
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(8);
        n2.left = n5;
        n2.right = n6;

        Q62SearchTree q = new Q62SearchTree();
        System.out.println(q.KthNode(n0, 3).val);
    }

}
