import java.util.*;

public class Q33UglyNum {

    public boolean isUglyNum(int num, HashSet<Integer> uglyNums){
        int[] factors = new int[]{2, 3, 5};
        if (num < 1) {
            return false;
        }else if (num == 1) {
            return true;
        }else {
            int curr = num;
            boolean isUgly = true;
            while (curr > 1){
                boolean noRemainder = false;
                for (int factor: factors){
                    int result = curr / factor;
                    int remainder = curr - result * factor;
                    if (remainder == 0){
                        noRemainder = true;
                        curr = result;
                        break;
                    }
                }

                if (!noRemainder){
                    isUgly = false;
                    break;
                }

                if (uglyNums.contains(curr)){
                    break;
                }
            }
            return isUgly;
        }
    }

    public int GetUglyNumber_Solution_slow(int index) {
        if (index <= 0){
            return 0;
        }

        HashSet<Integer> uglyNums = new HashSet<>();

        int count = 1;
        int number = 1;
        while (count < index){
            number += 1;
            if (isUglyNum(number, uglyNums)){
                uglyNums.add(number);
                count += 1;
            }
        }
        return number;
    }

    public int min(int v1, int v2){
        return v1 < v2? v1 : v2;
    }

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0){
            return -1;
        }

        ArrayList<Integer> uglyNums = new ArrayList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();
        Queue<Integer> q5 = new LinkedList<>();
        int currUgly = 1;
        uglyNums.add(currUgly);
        for (int count = 1; count < index; ++count){
            q2.add(currUgly * 2);
            q3.add(currUgly * 3);
            q5.add(currUgly * 5);
            currUgly = min(min(q2.peek(), q3.peek()), q5.peek());
            uglyNums.add(currUgly);
            if (currUgly == q2.peek()){
                currUgly = q2.poll();
            }
            if (currUgly == q3.peek()){
                currUgly = q3.poll();
            }
            if (currUgly == q5.peek()){
                currUgly = q5.poll();
            }
        }
        return uglyNums.get(index-1);
    }

    public static void main(String[] args) {
        Q33UglyNum u = new Q33UglyNum();
        System.out.println(u.GetUglyNumber_Solution(100));
    }
}
