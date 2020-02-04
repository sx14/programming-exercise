import java.util.HashSet;

public class Q55LinkedListCycleEntrance {
    // 给一个链表，若其中包含环，
    // 请找出该链表的环的入口结点，否则，输出null。

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return ""+val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        HashSet<ListNode> allNodes = new HashSet<>();
        ListNode curr = pHead;
        while (curr != null){
            if (allNodes.contains(curr)){
                // 发现环
                break;
            }else {
                allNodes.add(curr);
                curr = curr.next;
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        Q55LinkedListCycleEntrance q = new Q55LinkedListCycleEntrance();
        ListNode n1 = new ListNode(1);
        n1.next = n1;
//        n1.next.next = new ListNode(3);
//        n1.next.next.next = n1;
        System.out.println(q.EntryNodeOfLoop(n1));
    }
}
