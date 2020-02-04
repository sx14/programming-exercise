import java.util.ArrayList;

public class Q60PrintTree {

// 从上到下按层打印二叉树，
// 同一层结点从左至右输出。
// 每一层输出一行。

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }



    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (pRoot == null) return result;
        ArrayList<TreeNode> curr = new ArrayList<>();
        curr.add(pRoot);

        while (curr.size() > 0){
            ArrayList<TreeNode> next = new ArrayList<>();
            for (TreeNode n: curr){
                if (n.left != null) next.add(n.left);
                if (n.right != null) next.add(n.right);
            }
            ArrayList<Integer> levelResult = new ArrayList<>();
            for (int i = 0 ; i < curr.size() ; ++ i)
                levelResult.add(curr.get(i).val);

            result.add(levelResult);
            curr = next;
        }

        return result;
    }

    public static void main(String[] args) {
        Q60PrintTree q = new Q60PrintTree();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;



        ArrayList<ArrayList<Integer>> out = q.Print(n1);
        int a= 1;
    }
}
