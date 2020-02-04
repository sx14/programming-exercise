public class Q37CountK {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null){
            return 0;
        }

        int cnt = 0;
        for (int v: array){
            if (k == v) cnt += 1;
        }
        return cnt;
    }
}
