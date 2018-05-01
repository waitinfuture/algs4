package chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by 周克勇 on 2018/4/29.
 */
public class BruteSearch {
    public static int rank(int k, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = StdIn.readAllInts();
        Arrays.sort(data);
        int rank = rank(Integer.parseInt(args[0]), data);
        for (int i = rank; i < rank + 100; i++) {
            StdOut.println(i + ":" + data[i]);
        }
    }
}
