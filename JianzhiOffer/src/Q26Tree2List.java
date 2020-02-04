import java.util.ArrayList;

public class Q26Tree2List {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    private static void midRootSort(TreeNode root, ArrayList<TreeNode> list){
        if (root.left != null){
            midRootSort(root.left, list);
        }
        list.add(root);
        if (root.right != null){
            midRootSort(root.right, list);
        }
    }

    public static TreeNode Convert(TreeNode pRootOfTree) {
        // 中根遍历，连接
        if (pRootOfTree == null){
            return null;
        }
        ArrayList<TreeNode> orderedList = new ArrayList<>();

        midRootSort(pRootOfTree, orderedList);
        TreeNode lastNode = null;
        for (int i=0; i<orderedList.size()-1;++i){
            TreeNode curr = orderedList.get(i);
            curr.left = lastNode;
            curr.right = orderedList.get(i+1);
            lastNode = curr;
        }
        int listLen = orderedList.size();
        if (listLen > 1){
            orderedList.get(listLen-1).left = orderedList.get(listLen-2);
        }
        return orderedList.get(0);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(9);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(10);
        TreeNode head = Convert(root1);
        int a = 1;
    }
}
