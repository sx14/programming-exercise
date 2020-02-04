public class Q11CountBit1 {
    public static int NumberOf1s(int n) {
        return Integer.bitCount(n);
    }

    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0){
            n = n & (n-1);
            count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(1));
    }
}
