package chapter1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 周克勇 on 2018/4/30.
 */
public class pow {
    // pow(n, m)
    public static void pow(int n, int m) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = 1;
        }

        pow(0, n, arr);
    }

    public static void pow(int cur, int max, int[] arr) {
        if (cur == arr.length) {
            StdOut.println(arr, arr.length);
            return;
        }

        for (int i = 1; i <= max; i++) {
            int tmp = arr[cur];
            arr[cur] = i;
            pow(cur + 1, max, arr);
            arr[cur] = tmp;
        }
    }

    public static void main(String[] args) {
        pow(3,3);
    }
}
