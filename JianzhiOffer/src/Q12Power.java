public class Q12Power {
    public static double Power(double base, int exponent) {
        double result = 1;
        boolean positive = exponent >= 0;
        int absExp = exponent < 0? -exponent:exponent;
        for (int i=0;i<absExp;++i){
            result *= base;
        }
        if (!positive){
            result = 1 / result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Power(0, -2));
    }
}
