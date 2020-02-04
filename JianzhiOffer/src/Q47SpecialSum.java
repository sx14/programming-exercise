public class Q47SpecialSum {

    public int Sum_Solution(int n) {
        // 利用短路代替if else
        int ans = n;
        boolean t = (ans > 0) && (ans += Sum_Solution(n-1)) > 0;
        return ans;
    }

    public static void main(String[] args) {
        Q47SpecialSum q = new Q47SpecialSum();
        System.out.println(q.Sum_Solution(5));
    }
}
