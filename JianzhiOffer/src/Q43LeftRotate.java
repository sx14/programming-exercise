public class Q43LeftRotate {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n < 0) return "";

        int strLen = str.length();
        int realN = n % strLen;
        String head = str.substring(0, realN);
        String tail = str.substring(realN, str.length());
        return tail + head;
    }

    public static void main(String[] args) {
        Q43LeftRotate q = new Q43LeftRotate();
        System.out.println(q.LeftRotateString("123ABC...", 0));
    }
}
