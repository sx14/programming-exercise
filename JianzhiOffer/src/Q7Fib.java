public class Q7Fib {
    public static int Fibonacci(int n) {
        if (n < 0){
            return 0;
        }

        int[] buffer = new int[]{0, 1};

        if (n < 2){
            return buffer[n];
        }else {
            for (int i=0; i<n-1; ++i){
                int sum = buffer[0] + buffer[1];
                buffer[0] = buffer[1];
                buffer[1] = sum;
            }

            return buffer[1];
        }
    }

    public static int Fibonacci0(int n) {
        if(n <= 0){
            return 0;
        }else if(n==1){
            return 1;
        }else{
            return Fibonacci(n-1) + Fibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        for (int i = -5; i < 10; ++i){
            System.out.println(String.format("%d - %d", Fibonacci0(i), Fibonacci(i)));
        }
    }
}
