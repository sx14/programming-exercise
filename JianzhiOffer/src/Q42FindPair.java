import java.util.ArrayList;

public class Q42FindPair {
    public ArrayList<Integer> FindNumbersWithSumSlow(int [] array, int sum) {
        if (array == null || array.length < 2) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < array.length - 1; ++ i){
            for (int j = i + 1; j < array.length; ++ j){
                if (array[i] + array[j] == sum){
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(array[i]);
                    pair.add(array[j]);
                    pairs.add(pair);
                }
            }
        }
        if (pairs.size() > 0){
            ArrayList<Integer> minPair = pairs.get(0);
            long minMul = minPair.get(0) * minPair.get(1);
            for (ArrayList<Integer> pair: pairs){
                long currMul = pair.get(0) * pair.get(1);
                if (currMul < minMul){
                    minMul = currMul;
                    minPair = pair;
                }
            }
            return minPair;
        }else {
            return new ArrayList<>();
        }
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if (array == null || array.length < 2) return new ArrayList<>();

        int ptr1 = 0;
        int ptr2 = array.length - 1;
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        while (ptr1 < ptr2){
            int pairSum = array[ptr1] + array[ptr2];
            if (pairSum == sum){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(array[ptr1]);
                pair.add(array[ptr2]);
                pairs.add(pair);
                ptr1 += 1;
                ptr2 -= 1;
            }else if (pairSum > sum){
                ptr2 -= 1;
            }else {
                ptr1 += 1;
            }
        }
        if (pairs.size() > 0) return pairs.get(0);
        else return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,4,99,100};
        Q42FindPair q = new Q42FindPair();
        System.out.println(q.FindNumbersWithSum(array, 101));
    }
}
