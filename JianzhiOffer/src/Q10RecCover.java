public class Q10RecCover {
    public static int RectCover(int target) {
        if (target < 0){
            return 0;
        }else if (target == 1){
            return 1;
        }else if (target == 2){
            return 2;
        }else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }


    public static void main(String[] args) {
        System.out.println(RectCover(4));
    }
}
