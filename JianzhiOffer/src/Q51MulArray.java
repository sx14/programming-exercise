public class Q51MulArray {

    public int[] multiply1(int[] A) {
        if (A == null) return null;
        int[] B = new int[A.length];

        for (int i = 0 ; i < B.length; ++ i){
            int currValue = 1;
            for (int j = 0; j < A.length; ++ j){
                if (j != i){
                    currValue *= A[j];
                }
            }
            B[i] = currValue;
        }
        return B;
    }

    public int[] multiply(int[] A) {
        if (A == null) return null;
        int[] B = new int[A.length];

        B[0] = 1;
        for (int i = 1; i < A.length ; ++ i){
            B[i] = B[i-1] * A[i-1];
        }

        int tmp = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; -- i){
            B[i] = B[i] * tmp;
            tmp *= A[i];
        }
        return B;
    }

    public static void main(String[] args) {
        Q51MulArray q = new Q51MulArray();
        int[] A = new int[]{1,2,3,4};
        int[] B = q.multiply(A);
        for (int v : B){
            System.out.println(v);
        }
    }
}
