public class Q35ReversePair {
    public int InversePairsSlow(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }

        int count = 0;
        for (int i = 0; i < array.length; ++ i){
            for (int j = i + 1; j < array.length; ++ j){
                int v1 = array[i];
                int v2 = array[j];
                if (v2 < v1){
                    count += 1;
                }
            }
        }
        return count % 1000000007;
    }


    public int InversePairs(int [] array, int ptr1, int ptr2) {
        // include ptr1, exclude ptr2

        if (ptr2 - ptr1 == 1){
            return 0;
        } else {
            int ptr11 = ptr1;
            int ptr12 = (ptr1 + ptr2) / 2;
            int ptr21 = ptr12;
            int ptr22 = ptr2;
            int cnt1 = InversePairs(array, ptr11, ptr12);
            int cnt2 = InversePairs(array, ptr21, ptr22);

            int cntCurr = 0;
            int iter1 = ptr12 - 1;
            int iter2 = ptr22 - 1;
            int[] tmp = new int[ptr2 - ptr1];
            int tmpPtr = tmp.length - 1;
            while (iter1 >= ptr11 && iter2 >= ptr21){
                int v1 = array[iter1];
                int v2 = array[iter2];
                if (v1 > v2){
                    cntCurr += (iter2 - ptr21 + 1);
                    cntCurr %= 1000000007;
                    iter1 -= 1;
                    tmp[tmpPtr] = v1;
                }else {
                    iter2 -= 1;
                    tmp[tmpPtr] = v2;
                }
                tmpPtr -= 1;
            }

            if (iter1 >= ptr11){
                for (int i = iter1; i >= ptr11; -- i){
                    tmp[tmpPtr] = array[i];
                    tmpPtr -= 1;
                }
            }else if (iter2 >= ptr21){
                for (int i = iter2; i >= ptr21; -- i){
                    tmp[tmpPtr] = array[i];
                    tmpPtr -= 1;
                }
            }

            for (int i = ptr1; i < ptr2; ++ i){
                array[i] = tmp[i-ptr1];
            }
            return (cnt1 + cnt2 + cntCurr) % 1000000007;
        }
    }


    public int InversePairs(int [] array) {
        // 归并排序的过程中记录逆序对
        int cnt = 0;
        if (array != null && array.length > 1){
            cnt = InversePairs(array, 0, array.length);
        }
        return cnt % 1000000007;
    }


    public static void main(String[] args) {
        Q35ReversePair q = new Q35ReversePair();
        int[] input = new int[]{1,2,3,4,5,6,7,0};
        System.out.println(q.InversePairs(input));
        System.out.println(Integer.MAX_VALUE);
    }
}
