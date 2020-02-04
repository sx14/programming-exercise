public class Q14BottomK {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindKthToTail1(ListNode head,int k) {
        if (head == null || k < 1){
            return null;
        }
        int currPtr = 0;
        ListNode curr = head;
        ListNode kNode = null;

        while (curr != null){
            curr = curr.next;
            currPtr += 1;

            if(currPtr == k) {
                kNode = head;
            }else if (currPtr > k){
                kNode = kNode.next;
            }
        }
        return kNode;
    }

    public static ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k < 1){
            return null;
        }

        ListNode curr = head;
        ListNode kNode = head;

        for (int i=0;i<k;++i){
            if (curr == null){
                return null;
            }
            curr = curr.next;
        }

        while (curr != null){
            curr = curr.next;
            kNode = kNode.next;
        }
        return kNode;
    }


    public static void main(String[] args) {
        int nodeNum = 5;
        ListNode head = null;
        for (int i=0;i<nodeNum;++i){
            ListNode curr = new ListNode(nodeNum-i);
            curr.next = head;
            head = curr;
        }
        ListNode kNode = FindKthToTail(head, 10);
        if (kNode != null){
            System.out.println(kNode.val);
        }else {
            System.out.println("null");
        }
    }
}
