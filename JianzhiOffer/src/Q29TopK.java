import java.util.ArrayList;

public class Q29TopK {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        // 冒泡
        ArrayList<Integer> results = new ArrayList<>();
        if (input == null || k <= 0){
            return results;
        }

        if (k > input.length){
            return results;
        }

        for (int i=0; i<k; ++i){
            for (int j=0; j<input.length-1-i; ++j){
                if (input[j] < input[j+1]){
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
            results.add(input[input.length-i-1]);
        }
        return results;

    }

    public static void main(String[] args) {
        int[] input = new int[] {4,5,1,6,2,7,3,8};
        ArrayList<Integer> topK = GetLeastNumbers_Solution(input, 8);
        int a= 1;
    }
}
