import sun.awt.image.ImageWatched;

public class Q46Joseph {

    public class LinkedNode{
        int id;
        LinkedNode next;

        public LinkedNode(int id){
            this.id = id;
        }
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) return -1;

        // init cycle
        LinkedNode stubHead = new LinkedNode(-1);
        LinkedNode lastNode = stubHead;
        for (int i = 0; i < n; ++ i){
            LinkedNode curr = new LinkedNode(i);
            lastNode.next = curr;
            lastNode = curr;
        }
        // finish cycle
        lastNode.next = stubHead.next;

        LinkedNode last = lastNode;
        LinkedNode curr = stubHead.next;
        int cnt = 0;
        while (curr.next != curr){
            if (cnt == m - 1){
                last.next = curr.next;
                cnt = 0;
                curr = curr.next;
            }else {
                last = last.next;
                curr = curr.next;
                cnt += 1;
            }
        }

        return curr.id;
    }

    public static void main(String[] args) {
        Q46Joseph q = new Q46Joseph();
        System.out.println(q.LastRemaining_Solution(5, 2));
    }
}
