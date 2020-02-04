public class Q23BinarySearchTree {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0){
            return false;
        }

        int root = sequence[sequence.length-1];
        int border = 0;
        while (sequence[border] < root){
            border += 1;
        }
        int[] left = new int[border];
        int[] right = new int[sequence.length-border-1];
        for (int i=0;i<sequence.length-1;++i){
            if (i < border){
                left[i] = sequence[i];
            }else {
                if (sequence[i] < root){
                    return false;
                }
                right[i-border] = sequence[i];
            }
        }
        if (left.length == 0 && right.length == 0){
            return true;
        }else if (left.length == 0 && right.length != 0){
            return VerifySquenceOfBST(right);
        }else if (left.length != 0 && right.length == 0){
            return VerifySquenceOfBST(left);
        }else {
            return VerifySquenceOfBST(left) && VerifySquenceOfBST(right);
        }
    }

    public static void main(String[] args) {
        int[] values = new int[0];
        System.out.println(VerifySquenceOfBST(values));
    }
}
