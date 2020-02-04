public class Q31Count1 {

    public static int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        int curr = n;
        int currTimes = 1;
        while (curr > 0){
            int currCount = curr / 10;
            int currLast = curr - currCount * 10;
            if (currLast > 1){
                currCount += 1;
            }else if (currLast == 1){
                sum += n - curr * currTimes + 1;
            }
            sum += currCount * currTimes;
            currTimes *= 10;
            curr /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(1));
    }

}
