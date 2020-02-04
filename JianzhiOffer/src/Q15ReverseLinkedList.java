public class Q15ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode ReverseList(ListNode head) {
        ListNode curr = head;
        ListNode next = null;
        ListNode last = null;

        while (curr != null){
            next = curr.next;
            curr.next = last;
            last = curr;
            curr = next;
        }
        return last;
    }

    public static void main(String[] args) {
        int nodeNum = 1;
        ListNode head = null;
        for (int i=0;i<nodeNum;++i){
            ListNode curr = new ListNode(nodeNum-i);
            curr.next = head;
            head = curr;
        }

        ListNode rHead = ReverseList(head);
        int a = 1;
    }
}
