import java.util.LinkedList;
import java.util.Queue;

public class Q34FirstOnlyOne {
    public int FirstNotRepeatingChar(String str) {
        int[] char2cnt = new int[128];
        int[] char2Ind = new int[128];
        int[] onceChars = new int[52];

        int nextOnceCharInd = 0;
        for (int i = 0; i < str.length(); ++ i){
            int currChar = str.charAt(i);
            if (currChar > 127){
                return -1;
            }
            if (char2cnt[currChar] == 0){
                onceChars[nextOnceCharInd] = currChar;
                char2Ind[currChar] = i;
                nextOnceCharInd += 1;
            }
            char2cnt[currChar] += 1;
        }

        for (int i = 0; i < nextOnceCharInd; ++i){
            int onceChar = onceChars[i];
            if (char2cnt[onceChar] == 1){
                return char2Ind[onceChar];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q34FirstOnlyOne q = new Q34FirstOnlyOne();
        System.out.println(q.FirstNotRepeatingChar("aAbcadef"));
    }
}
