import java.util.ArrayList;
import java.util.Collections;

public class Q41SeqSum {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (sum < 2) return results;

        for (int i = 2; i < sum; ++ i){

            double avg = sum * 1.0 / i;
            int mid = sum / i;
            boolean ok = false;
            if (i % 2 == 1 && avg - mid == 0){
                ok = true;
            }else if (i % 2 == 0 && avg - mid == 0.5){
                ok = true;
            }

            if (ok){
                ArrayList<Integer> seq = new ArrayList<>();
                int start = mid - i / 2;
                int end = mid + i / 2 + 1;
                if (i % 2 == 0){
                    start += 1;
                }

                if (start <= 0){
                    break;
                }

                for (int v = start; v < end; v ++){
                    seq.add(v);
                }
                results.add(seq);
            }
        }
        Collections.reverse(results);
        return results;
    }

    public static void main(String[] args) {
        Q41SeqSum q = new Q41SeqSum();
        System.out.println(q.FindContinuousSequence(100));
    }
}
