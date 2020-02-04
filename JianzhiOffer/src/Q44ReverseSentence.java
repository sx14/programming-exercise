public class Q44ReverseSentence {
    public boolean spaceOnly(String str){
        boolean spaceOnly = true;
        for (int i = 0 ; i < str.length(); ++ i){
            if (str.charAt(i) != ' '){
                spaceOnly = false;
            }
        }

        return spaceOnly;
    }

    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) return "";
        if (spaceOnly(str)) return str;

        String[] words = str.split(" ");
        for (int i = 0 ; i < words.length / 2; ++ i){
            String word1 = words[i];
            String word2 = words[words.length - i - 1];
            words[i] = word2;
            words[words.length - i - 1] = word1;
        }

        StringBuffer result = new StringBuffer();
        for (String word: words) {
            result.append(word);
            result.append(' ');
        }

        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        Q44ReverseSentence q = new Q44ReverseSentence();
        System.out.println(q.ReverseSentence("   "));
    }
}
