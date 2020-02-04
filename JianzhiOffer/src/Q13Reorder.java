import java.util.ArrayList;
import java.util.List;

public class Q13Reorder {
    public static void reOrderArray0(int [] array) {
        if (array == null || array.length == 0){
            return;
        }
        List odds = new ArrayList<Integer>();
        List evens = new ArrayList<Integer>();
        for (int value: array){
            if (value % 2 == 0){
                evens.add(value);
            }else {
                odds.add(value);
            }
        }
        int oddLen = odds.size();
        for (int i=0;i<odds.size();++i){
            array[i] = (int) odds.get(i);
        }
        for (int j=0;j<evens.size();++j){
            array[oddLen+j] = (int) evens.get(j);
        }
    }

    public static void reOrderArray(int [] array) {
        if (array == null || array.length == 0){
            return;
        }

        int lastOddPos = -1;
        for (int i=0;i<array.length;++i){
            if (array[i] % 2 != 0){
                // find an odd
                for (int j=i;j>lastOddPos+1;--j){
                    int tmp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = tmp;
                }
                lastOddPos += 1;
            }
        }
    }



    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        reOrderArray(array);
        System.out.println(array.toString());
    }
}
