public class Q48Add {

    public int Add(int num1,int num2) {
        while (num2 != 0){
            // 按位相加，忽略进位
            int sumTmp = num1 ^ num2;
            // 本次运算的进位
            // 由于是进位，要乘一个base，二进制就是乘2,即左移1位
            int carry = (num1 & num2) << 1;
            num1 = sumTmp;
            num2 = carry;
            // 在下次循环中，进位carry与按位加结果sumTmp再求和
        }
        return num1;
    }

    public static void main(String[] args) {
        Q48Add q = new Q48Add();
        System.out.println(q.Add(956, 979));
    }
}
