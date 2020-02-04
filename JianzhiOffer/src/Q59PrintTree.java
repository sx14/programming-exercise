import java.util.ArrayList;

public class Q59PrintTree {
// 请实现一个函数按照之字形打印二叉树，
// 即第一行按照从左到右的顺序打印，
// 第二层按照从右至左的顺序打印，
// 第三行按照从左到右的顺序打印，其他行以此类推。

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

        int levelCnt = 1;
        while (curr.size() > 0){
            ArrayList<TreeNode> next = new ArrayList<>();
            for (TreeNode n: curr){
                if (n.left != null) next.add(n.left);
                if (n.right != null) next.add(n.right);
            }
            ArrayList<Integer> levelResult = new ArrayList<>();
            if (levelCnt % 2 == 1){
                // 奇数level
                for (int i = 0 ; i < curr.size() ; ++ i)
                    levelResult.add(curr.get(i).val);
            } else {
                // 偶数level
                for (int i = curr.size() - 1; i >= 0 ; -- i)
                    levelResult.add(curr.get(i).val);
            }
            result.add(levelResult);
            levelCnt += 1;
            curr = next;
        }

        return result;
    }

    public static void main(String[] args) {
        Q59PrintTree q = new Q59PrintTree();

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
