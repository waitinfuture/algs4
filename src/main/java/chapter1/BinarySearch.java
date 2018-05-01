package chapter1;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * Created by 周克勇 on 2018/4/29.
 */
public class BinarySearch {
    public static int rank(int k, int[] arr) {
        return rank(k, 0, arr.length, arr);
    }

    public static int rank(int k, int lo, int hi, int[] arr) {
        if (lo > hi) {
            return -1;
        }
        int middle = lo + (hi - lo) / 2;
        if (arr[middle] == k) {
            return middle;
        } else if (arr[middle] < k) {
            return rank(k, middle + 1, hi, arr);
        } else {
            return rank(k, lo, middle, arr);
        }
    }

    public static void main(String[] args) {
        int[] data = StdIn.readAllInts();
        Arrays.sort(data);
        System.out.println(rank(Integer.parseInt(args[0]), 0, data.length, data));
    }
}
