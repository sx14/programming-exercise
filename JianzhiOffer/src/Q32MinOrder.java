import java.util.ArrayList;
import java.util.Collections;

public class Q32MinOrder {

    public static String PrintMinNumber(int [] numbers) {
        if (numbers == null){
            return null;
        }

        String[] strNums = new String[numbers.length];
        for (int i = 0; i < numbers.length ; ++i){
            strNums[i] = String.valueOf(numbers[i]);
        }

        for (int i=0; i<numbers.length-1; ++i){
            for (int j=0; j<numbers.length-i-1; ++j){
                String s1 = strNums[j];
                String s2 = strNums[j+1];
                String s1s2 = s1 + s2;
                String s2s1 = s2 + s1;
                for (int k=0; k<s1s2.length(); ++k){
                    if (s1s2.charAt(k) > s2s1.charAt(k)){
                        strNums[j] = s2;
                        strNums[j+1] = s1;
                        break;
                    } else if (s1s2.charAt(k) < s2s1.charAt(k)){
                        break;
                    }
                }
            }
        }

        StringBuffer result = new StringBuffer();
        for (String s: strNums){
            result.append(s);
        }
        return result.toString();
    }


    class Value{
        int value;
        String strValue;
        String strValueTemp;
        Value(int value){
            this.value = value;
            strValue = String.valueOf(value);
            strValueTemp = String.valueOf(value);
        }

        int realLen(){
            return strValue.length();
        }

        int currLen(){
            return strValueTemp.length();
        }

    }

    private void sortStringAt(ArrayList<Value> strNums, int at) {


    }

    public String PrintMinNumber1(int [] numbers) {
        ArrayList<Value> values = new ArrayList<>();
        int maxLen = -1;
        for (int i=0; i<numbers.length; ++i){
            Value currValue = new Value(numbers[i]);
            values.add(currValue);
            maxLen = currValue.realLen() > maxLen ? currValue.realLen() : maxLen;
        }

        for (int i = 0; i < maxLen ; ++ i){
            sortStringAt(values, i);
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (Value v : values){
            stringBuffer.append(v.strValue);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        int[] nums = {13, 12, 33, 331, 3};
        System.out.println(PrintMinNumber(nums));
    }
}
