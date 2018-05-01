package chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 周克勇 on 2018/4/29.
 */
public class Average {
    public static void main(String[] args) {
        double sum = 0;
        int cnt = 0;
        while (!StdIn.isEmpty()) {
            sum += StdIn.readDouble();
            cnt++;
        }
        StdOut.println(sum /cnt);
    }
}
