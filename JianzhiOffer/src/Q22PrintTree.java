import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q22PrintTree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> out = new ArrayList<>();

        if (root == null){
            return out;
        }

        // BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            out.add(curr.val);
            if (curr.left != null){
                queue.add(curr.left);
            }
            if (curr.right != null){
                queue.add(curr.right);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(5);

        ArrayList<Integer> out = PrintFromTopToBottom(root1);
        int a = 1;
    }

}
