package chapter1;

import chapter1.base.ArrUtil;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 周克勇 on 2018/4/30.
 */
public class Perm {
    // P(n,m)
    public static void perm(int n, int m) {
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        StdOut.println(arr, n);
        perm(0, m, arr);
    }

    public static void perm(int from, int end, int[] arr) {
        if (from == end) {
            StdOut.println(arr, end);
            return;
        }

        for (int i = from; i < arr.length; i++) {
            ArrUtil.swap(from, i, arr);
            perm(from + 1, end, arr);
            ArrUtil.swap(from, i, arr);
        }
    }

    public static void main(String[] args) {
        perm(4,2);
    }
}
