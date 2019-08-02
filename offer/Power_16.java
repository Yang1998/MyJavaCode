package offer;

public class Power_16 {
    public static double pow(double base, int exponent) {
        double res = helper(base, Math.abs(exponent));
        if(exponent < 0)
            return 1.0 / res;
        return res;
    }

    private static double helper(double base, int exponent) {
        if(exponent == 0)
            return 1.0;
        if(exponent == 1)
            return base;
        if((exponent & 1) == 1) {
            return base * helper(base, exponent - 1);
        }
        else{
            double tmp = helper(base, exponent >> 1);
            return tmp * tmp;
        }
    }
}
