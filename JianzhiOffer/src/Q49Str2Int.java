public class Q49Str2Int {

    public boolean isNum(char c){
        return c >= '0' && c <= '9';
    }

    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;

        long value = 0;
        int strLen = str.length();
        for (int i = strLen - 1; i >= 0; -- i){
            if (isNum(str.charAt(i))){
                value += (str.charAt(i) - '0') * Math.pow(10, strLen - i - 1);
            }else if (i == 0 && str.charAt(i) == '-'){
                value *= -1;
            }else if (i == 0 && str.charAt(i) == '+'){
                value *= 1;
            }else {
                value = 0;
                break;
            }
        }

        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE){
            value = 0;
        }

        return (int) value;
    }

    public static void main(String[] args) {
        Q49Str2Int q = new Q49Str2Int();
        System.out.println(q.StrToInt("1a44"));
    }

}
