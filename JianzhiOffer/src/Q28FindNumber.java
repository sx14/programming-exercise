import java.util.HashMap;

public class Q28FindNumber {
    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array == null){
            return 0;
        }

        int maxCount = 0;
        int maxValue = 0;
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i=0; i<array.length; ++i){
            int curr = array[i];
            if (counter.containsKey(curr)){
                counter.put(curr, counter.get(curr)+1);
            }else {
                counter.put(curr, 1);
            }
            int currCount = counter.get(curr);
            if (currCount > maxCount){
                maxCount = currCount;
                maxValue = curr;
            }
        }
        if (maxCount > array.length / 2){
            return maxValue;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(input));
    }
}
