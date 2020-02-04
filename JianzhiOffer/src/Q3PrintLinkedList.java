import java.util.ArrayList;


public class Q3PrintLinkedList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> outList = new ArrayList<>();
        while (listNode != null){
            outList.add(0, listNode.val);
            listNode = listNode.next;
        }
        return outList;
    }

}
