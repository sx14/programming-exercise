import java.util.ArrayList;
import java.util.Collections;

public class Q45Poker {

    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) return false;

        ArrayList<Integer> nums = new ArrayList<>();
        int zeroCounter = 0;

        for (int v: numbers){
            if (v == 0) zeroCounter += 1;
            else nums.add(v);
        }

        Collections.sort(nums);
        boolean result = true;
        for (int i = 0; i < nums.size() - 1; ++ i){
            int v1 = nums.get(i);
            int v2 = nums.get(i+1);
            if (v1 == v2 || v2 - v1 > zeroCounter + 1){
                result = false;
                break;
            }else {
                zeroCounter -= (v2 - v1 - 1);
            }

        }
        if (zeroCounter < 0) result = false;
        return result;
    }


    public static void main(String[] args) {
        Q45Poker q = new Q45Poker();
        int[] input = new int[]{1,0,0,5,0};
        System.out.println(q.isContinuous(input));
    }

}
