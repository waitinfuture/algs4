package chapter1;

import chapter1.base.ArrUtil;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 周克勇 on 2018/4/30.
 */
public class Comb {
    // C(n,m)
    public static void comb(int n, int m) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        comb(0, -1, m, arr);
    }

    public static void comb(int cur, int last, int end, int[] arr) {
        if (cur == end) {
            StdOut.println(arr, end);
            return;
        }

        int from = Math.max(cur, last + 1);
        for (int i = from; i <= arr.length - (end - cur); i++) {
            ArrUtil.swap(cur, i, arr);
            comb(cur + 1, i, end, arr);
            ArrUtil.swap(cur, i, arr);
        }
    }

    public static void main(String[] args) {
        comb(5,3);
    }
}
