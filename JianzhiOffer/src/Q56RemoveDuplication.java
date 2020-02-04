public class Q56RemoveDuplication {
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

    public ListNode deleteDuplication(ListNode pHead){
        if (pHead == null || pHead.next == null) return pHead;
        ListNode head = pHead;

        ListNode last = null;
        ListNode curr = pHead;
        while (curr != null){
            //tmp是与curr相同的最后一个节点
            ListNode tmp = curr;
            while (tmp.next != null && tmp.next.val == tmp.val && curr != tmp.next)
                tmp = tmp.next;

            if (curr == tmp.next){
                // 环
                if (last != null)
                    last.next = null;
                return last;
            }

            if (tmp != curr){
                // 重复
                if (last != null){
                    last.next = tmp.next;
                    curr = tmp.next;
                }else {
                    curr = tmp.next;
                    head = curr;
                }
            }else {
                last = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Q56RemoveDuplication q = new Q56RemoveDuplication();
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(2);
        n1.next.next.next = new ListNode(2);
        n1.next.next.next.next = n1.next;

        System.out.println(q.deleteDuplication(n1));
    }
}
