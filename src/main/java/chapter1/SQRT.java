package chapter1;

/**
 * Created by 周克勇 on 2018/4/21.
 */
public class SQRT {
    public static double sqrt(double c) {
        if (c < 0) {
            return Double.NaN;
        }
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c / t) > c *err) {
            t = (t + c / t) / 2.0;
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(-4));
        System.out.println(sqrt(0));
    }
}
