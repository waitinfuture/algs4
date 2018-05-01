package chapter1;

import chapter1.base.StdRandom;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 周克勇 on 2018/4/29.
 */
public class RandomSeq {
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);

        StdOut.printf("%.2f\n", StdRandom.uniform(lo, hi));
        for (int i = 0; i < N; i++) {
        }

        StdDraw.circle(10, 10, 10);
        StdDraw.line(0,0,10,10);
        StdDraw.filledCircle(5,5,5);
        StdDraw.square(5,5,5);

        StdOut.println(1/0.0);
    }
}
