import java.util.Stack;

public class Q21PopOrder {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length){
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int pushPtr = 0;
        int popPtr = 0;
        boolean match = true;
        while (popPtr < popA.length){
            int popCurr = popA[popPtr];
            if (stack.empty() || stack.peek() != popCurr){
                if (pushPtr >= pushA.length){
                    match = false;
                    break;
                }
                stack.push(pushA[pushPtr]);
                pushPtr += 1;
            }else {
                stack.pop();
                popPtr += 1;
            }
        }
        return match;
    }

    public static void main(String[] args) {
        int[] push = new int[]{1,2,3,4,5};
        int[] pop = new int[]{4,3,5,1,2};
        System.out.println(IsPopOrder(push, pop));
    }
}
