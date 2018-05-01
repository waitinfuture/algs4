package chapter1;

import chapter1.base.StdRandom;
import edu.princeton.cs.algs4.StdDraw;

/**
 * Created by 周克勇 on 2018/4/29.
 */
public class Draw {
    public static void main(String[] args) {
        int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N * N);
        for (int i = 0; i < N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i * Math.log(i));
        }

        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        for (int i = 0; i < a.length; i++) {
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double xw = 0.5 / N;
            double yh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, xw, yh);
        }
    }
}
