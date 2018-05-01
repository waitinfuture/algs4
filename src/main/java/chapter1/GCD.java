package chapter1;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by 周克勇 on 2018/4/21.
 */
public class GCD {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(12, 14));
        for (int i = 0; i < 10; i++) {
            System.out.println(StdRandom.bernoulli(0.5));
        }
    }
}
