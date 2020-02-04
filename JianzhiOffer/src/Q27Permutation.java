import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Q27Permutation {

    private static ArrayList<String> Permutation1(ArrayList<Character> sortedChars){
        ArrayList<String> results = new ArrayList<>();
        if (sortedChars.size() == 1){
            String str = "" + sortedChars.get(0);
            results.add(str);
        }else {
            HashSet<Character> allHeads = new HashSet<>();
            for (int i=0; i<sortedChars.size(); ++i){
                char head = sortedChars.get(i);
                if (allHeads.contains(head)){
                    continue;
                }else {
                    allHeads.add(head);
                }
                ArrayList<Character> lastChars = new ArrayList<>(sortedChars);
                lastChars.remove(i);
                ArrayList<String> subResults = Permutation1(lastChars);
                for (String str: subResults){
                    results.add(head + str);
                }
            }
        }
        return results;
    }

    public static ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0){
            return new ArrayList<>();
        }

        ArrayList<Character> charList = new ArrayList<>();
        for (int i=0; i<str.length(); ++i){
            charList.add(str.charAt(i));
        }
        Collections.sort(charList);
        return Permutation1(charList);
    }

    public static void main(String[] args) {
        ArrayList<String> per = Permutation("aAbb");
        int a = 1;
    }
}
