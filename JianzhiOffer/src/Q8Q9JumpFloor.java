public class Q8Q9JumpFloor {
    public static int JumpFloor(int target) {
        if (target < 0) {
            return 0;
        } else if (target <= 2){
            return target;
        } else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }

    public static int JumpFloorII(int target) {
        if (target <= 0){
            return 0;
        } else {
            int step = 1;
            for (int i=target-1;i>0;--i){
                step += JumpFloorII(i);
            }
            return step;
        }
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII(3));
    }
}
