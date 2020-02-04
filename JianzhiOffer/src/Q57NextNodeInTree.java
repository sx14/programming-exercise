import javax.xml.transform.ErrorListener;

public class Q57NextNodeInTree {

// 给定一个二叉树和其中的一个结点，
// 请找出中序遍历顺序的下一个结点并且返回。
// 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
// TODO: [ATTENTION] not easy


    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }


    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.right != null) {
            // 右子树不为空
            // 返回右子树中序遍历的第一个节点
            return getFirst(pNode.right);
        } else {
            // 右子树为空
            // 向上找未访问的第一个祖先节点
            return getParent(pNode);
        }
    }

    public TreeLinkNode getParent(TreeLinkNode node){
        // node是树的某个非根节点，且右子树是空
        // 返回中序遍历下的下一个节点
        if (node.next != null){
            if (node.next.left == node){
                // 当前节点是父节点的左孩子
                return node.next;
            }else {
                return getParent(node.next);
            }
        } else {
            return null;
        }
    }

    public TreeLinkNode getFirst(TreeLinkNode node){
        // node是根
        // 返回中序遍历下的第一个节点
        assert node != null;

        if (node.left == null){
            return node;
        }else{
            return getFirst(node.left);
        }
    }

    public static void main(String[] args) {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);
        TreeLinkNode n8 = new TreeLinkNode(8);
        TreeLinkNode n9 = new TreeLinkNode(9);

        n1.right = n2;
        n2.next = n1;

        n2.left = n3;
        n3.next = n2;

        n3.right = n4;
        n4.next = n3;

        n4.left = n5;
        n5.next = n4;

        Q57NextNodeInTree q = new Q57NextNodeInTree();
        System.out.println(q.GetNext(n4));

    }



}
