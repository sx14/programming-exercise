import java.util.ArrayList;
import java.util.LinkedList;

public class Q61SerializeTree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

// 请实现两个函数，分别用来序列化和反序列化二叉树
//
// 二叉树的序列化是指：
// 把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
// 从而使得内存中建立起来的二叉树可以持久保存。
// 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
// 序列化的结果是一个字符串，序列化时通过某种符号表示空节点（#），
// 以 ！ 表示一个结点值的结束（value!）。
//
// 二叉树的反序列化是指：
// 根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。

    private void rootFirst(TreeNode node, ArrayList<TreeNode> nodes){
        nodes.add(node);
        if (node != null){
            rootFirst(node.left, nodes);
            rootFirst(node.right, nodes);
        }
    }

    private TreeNode recover(LinkedList<String> treeStrs){
        String currStr = treeStrs.get(0);
        if (currStr.equals("#")){
            treeStrs.remove(0);
            return null;
        }else {
            TreeNode curr = new TreeNode(Integer.valueOf(currStr));
            treeStrs.remove(0);
            curr.left = recover(treeStrs);
            curr.right = recover(treeStrs);
            return curr;
        }
    }


    String Serialize(TreeNode root) {
        ArrayList<TreeNode> rootFirstArray = new ArrayList<>();
        rootFirst(root, rootFirstArray);
        StringBuffer sb = new StringBuffer();
        for (TreeNode node : rootFirstArray){
            if (node == null){
                sb.append('#');
                sb.append('!');
            }else {
                sb.append(String.valueOf(node.val));
                sb.append('!');
            }
        }
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        String[] nodeStrs = str.split("!");
        LinkedList<String> treeStrs = new LinkedList<String>();
        for (String s: nodeStrs) treeStrs.add(s);
        return recover(treeStrs);
    }



    public static void main(String[] args) {
        Q61SerializeTree q = new Q61SerializeTree();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        String treeStr = q.Serialize(n1);
        System.out.println(treeStr);
        TreeNode t = q.Deserialize(treeStr);
        int a = 1;
    }

}
