public class Q30MaxSubArray {
    public static int FindGreatestSumOfSubArray0(int[] array) {
        if (array == null || array.length == 0){
            return 0;
        }

        int maxSum = array[0];
        for (int subLen = 1; subLen <= array.length; ++subLen){
            for (int i=0;i<array.length-subLen+1; ++i){
                int subSum = 0;
                for (int j=0; j<subLen; ++j){
                    subSum += array[i+j];
                }
                maxSum = subSum > maxSum ? subSum : maxSum;
            }
        }
        return maxSum;
    }

    public static int FindGreatestSumOfSubArray1(int[] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        // DP[i] = max{DP[i-1]+array[i], array[i]}
        // DP[i]表示以第i个元素为结尾的最大连续子序列
        int maxSum = array[0];
        int curSum = array[0];
        for (int i=1;i<array.length;++i){
            if (curSum + array[i] > array[i]){
                curSum += array[i];
            }else {
                curSum = array[i];
            }
            maxSum = curSum > maxSum ? curSum : maxSum;
        }

        return maxSum;
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        // DP[i] = max{DP[i-1]+array[i], array[i]}
        // DP[i]表示以第i个元素为结尾的最大连续子序列
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int maxValue = array[0];
        for (int i=1; i<array.length; ++i){
            if (dp[i-1] + array[i] > array[i]){
                dp[i] = dp[i-1] + array[i];
            }else {
                dp[i] = array[i];
            }
            maxValue = dp[i] > maxValue ? dp[i] : maxValue;
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] input = new int[]{6,-3,-2,7,-15,1,2,2};
        System.out.println(FindGreatestSumOfSubArray(input));
    }
}
