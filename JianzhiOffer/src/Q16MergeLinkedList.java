public class Q16MergeLinkedList {
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        // merge list2 to list1
        // prepare: add a fake head (-Inf)
        ListNode stubHead1 = new ListNode(Integer.MIN_VALUE);
        stubHead1.next = list1;
        ListNode curr1 = stubHead1;

        // start merging
        ListNode insertHead = list2;
        ListNode insertTail = insertHead;
        while (curr1.next != null && insertHead != null){
            ListNode next1 = curr1.next;
            // try [curr1, next1)
            if (insertHead.val >= curr1.val && insertHead.val < next1.val){
                ListNode insertTemp = insertTail;
                while (insertTemp != null && insertTemp.val < next1.val){
                    insertTail = insertTemp;
                    insertTemp = insertTemp.next;
                }

                // insert
                curr1.next = insertHead;
                insertHead = insertTail.next;
                insertTail.next = next1;
                insertTail = insertHead;

            }
            curr1 = next1;
        }
        if (insertHead != null){
            curr1.next = insertHead;
        }
        return list1;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(10);
        head1.next.next.next = new ListNode(20);

        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);

        ListNode mHead = Merge(head1, head2);
        int a = 1;
    }

}
