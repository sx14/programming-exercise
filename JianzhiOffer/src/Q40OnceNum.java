import java.util.HashSet;
import java.util.Iterator;

public class Q40OnceNum {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2 ||
                num1 == null || num2 == null ||
                num1.length == 0 || num2.length == 0) return;

        HashSet<Integer> counter = new HashSet<>();
        for (int val: array){
            if (counter.contains(val)) counter.remove(val);
            else counter.add(val);
        }
        assert counter.size() == 2;

        Iterator<Integer> iter = counter.iterator();
        int cnt = 0;
        while (iter.hasNext()){
            if (cnt == 0) {
                num1[0] = iter.next();
                cnt += 1;
            } else num2[0] = iter.next();
        }
    }


    public static void main(String[] args) {
        int[] in = new int[] {1,2,3,1,2,4};
        int[] num1 = new int[1];
        int[] num2 = new int[2];
        Q40OnceNum q = new Q40OnceNum();
        q.FindNumsAppearOnce(in, num1, num2);
        System.out.println(String.format("%d, %d", num1[0], num2[0]));
    }
}
