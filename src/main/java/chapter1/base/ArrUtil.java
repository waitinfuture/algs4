package chapter1.base;

import java.util.List;

/**
 * Created by 周克勇 on 2018/4/30.
 */
public class ArrUtil {
    public static void swap(int a, int b, int[] arr) {
        int tmp =  arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static double sum(double[] arr) {
        double total = 0.0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total;
    }

    public static int sum(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total;
    }

    public static void norm(double[] arr) {
        double sum = sum(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] /= sum;
        }
    }

    public static boolean contains(int[] list, int a) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == a) {
                return true;
            }
        }
        return false;
    }


    public static boolean contains(List<Integer> list, int a) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == a) {
                return true;
            }
        }
        return false;
    }
}
