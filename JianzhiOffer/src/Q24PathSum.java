import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q24PathSum {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private static ArrayList<ArrayList<Integer>> dfs(TreeNode node, int currSum, int target, ArrayList<Integer> currPath0){
        currSum += node.val;
        ArrayList<Integer> currPath = new ArrayList<>(currPath0);
        currPath.add(node.val);
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (node.left == null && node.right == null && currSum == target){
            // reach leaf, good path!
            results.add(currPath);
        }
        if (node.left != null && currSum < target) {
            ArrayList<ArrayList<Integer>> leftPaths = dfs(node.left, currSum, target, currPath);
            results.addAll(leftPaths);
        }
        if (node.right != null && currSum < target){
            ArrayList<ArrayList<Integer>> rightPaths = dfs(node.right, currSum, target, currPath);
            results.addAll(rightPaths);
        }
        return results;
    }


    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> results = dfs(root, 0, target, new ArrayList<>());
        Collections.sort(results, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1 == null || o2 == null){
                    return 0;
                }else if (o1.size() == o2.size()){
                    return 0;
                }else if (o1.size() < o2.size()){
                    return 1;
                }else {
                    return -1;
                }
            }
        });
        return results;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(3);
        root1.left.left.left = new TreeNode(1);
        ArrayList<ArrayList<Integer>> results = FindPath(root1, 4);
    }

}
