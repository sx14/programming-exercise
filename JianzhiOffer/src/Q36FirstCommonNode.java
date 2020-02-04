import java.util.HashSet;

public class Q36FirstCommonNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> nodes1 = new HashSet<>();
        ListNode head1 = pHead1;
        while (head1 != null){
            if (!nodes1.contains(head1)){
                nodes1.add(head1);
                head1 = head1.next;
            }else {
                break;
            }
        }

        ListNode head2 = pHead2;
        HashSet<ListNode> nodes2 = new HashSet<>();
        while (head2 != null){
            if (nodes1.contains(head2)){
                return head2;
            }

            if (!nodes2.contains(head2)){
                nodes2.add(head2);
                head2 = head2.next;
            }else {
                break;
            }
        }
        return null;
    }
}
