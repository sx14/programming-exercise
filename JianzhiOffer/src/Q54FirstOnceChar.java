import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q54FirstOnceChar {
    // 请实现一个函数用来找出字符流中第一个只出现一次的字符。
    // 例如，当从字符流中只读出前两个字符"go"时，
    // 第一个只出现一次的字符是"g"。
    // 当从该字符流中读出前六个字符“google"时，
    // 第一个只出现一次的字符是"l"。

    int[] counter = new int[256];
    ArrayList<Character> onceChars = new ArrayList<>();

    public void Insert(char ch) {
        if (counter[ch] == 0){ // 第一次
            onceChars.add(ch);
        }
        counter[ch] += 1;
    }
    public char FirstAppearingOnce() {
        if (onceChars.size() == 0) return '#';
        for (char c: onceChars){
            if (counter[c] == 1){
                return c;
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        Q54FirstOnceChar q = new Q54FirstOnceChar();
        String s = "google";
        char[] charStream = s.toCharArray();
        for (int i = 0 ; i < charStream.length ; ++ i){
            System.out.println("==========");
            System.out.println(s.substring(0, i+1));
            q.Insert(charStream[i]);
            System.out.println(q.FirstAppearingOnce());
            System.out.println("==========");
        }
    }
}
