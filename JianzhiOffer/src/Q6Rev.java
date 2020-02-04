public class Q6Rev {


    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }

        int minValue = Integer.MAX_VALUE;
        for (int v: array){
            minValue = v < minValue? v:minValue;
        }
        return minValue;
    }
}
