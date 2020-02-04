import java.util.ArrayList;
import java.util.HashMap;

public class Q25CopyLinkedList {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        // record node index
        HashMap<RandomListNode, Integer> pNode2Ind = new HashMap<>();
        RandomListNode pCurr = pHead;
        int pNodeInd = 0;
        while (pCurr != null){
            pNode2Ind.put(pCurr, pNodeInd);
            pNodeInd += 1;
            pCurr = pCurr.next;
        }

        // copy nodes (ignore random links)
        ArrayList<RandomListNode> nNodes = new ArrayList<>();
        RandomListNode nHead = new RandomListNode(pHead.label);
        RandomListNode nCurr = nHead;
        RandomListNode pNext = pHead.next;
        nNodes.add(nHead);
        while (pNext != null){
            nCurr.next = new RandomListNode(pNext.label);
            nNodes.add(nCurr.next);
            pNext = pNext.next;
            nCurr = nCurr.next;
        }

        // copy random links
        pCurr = pHead;
        nCurr = nHead;
        while (pCurr != null){
            RandomListNode randomLink = pCurr.random;
            if (randomLink != null){
                int pRandomLinkInd = pNode2Ind.get(randomLink);
                nCurr.random = nNodes.get(pRandomLinkInd);
            }
            nCurr = nCurr.next;
            pCurr = pCurr.next;
        }
        return nHead;
    }

    public static void main(String[] args) {
        // 0 > 1 > 2 > 3
        RandomListNode head = new RandomListNode(0);
        head.next = new RandomListNode(1);
        head.next.next = new RandomListNode(2);
        head.next.next.next = new RandomListNode(3);
        // 1 > 1
        head.next.random = head.next;
        // 0 > 2
        head.random = head.next.next;

        RandomListNode nHead = Clone(head);
        int a = 1;
    }
}
