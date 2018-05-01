package chapter1.base;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by 周克勇 on 2018/4/29.
 */
public class StdRandom {
    private static Random random = new Random();
    private static double delta = 0.000000001;

    public static double uniform() {
        return random.nextDouble();
    }

    public static int uniform(int n) throws Exception {
        if (n <= 0) {
            throw new Exception("neg");
        }
        return random.nextInt(n);
    }

    public static double uniform(double n) throws Exception {
        if (n <= 0) {
            throw new Exception("negtive");
        }

        return n * uniform();
    }

    public static int uniform(int lo, int hi) throws Exception {
        return lo + uniform(hi - lo);
    }

    public static double uniform(double lo, double hi) throws Exception {
        return lo + uniform(hi - lo);
    }

    public static int discrete(double[] a) {
        if (!validateDist(a)) {
            return -1;
        }

        double r = uniform();
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum >= r) {
                return i;
            }
        }

        return -1;
    }

    public static int nextInt(int a) {
        return random.nextInt(a);
    }

    public static boolean validateDist(double[] a) {
        if (a == null) {
            return false;
        }

        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                return false;
            }
            sum += a[i];
        }

        return Math.abs(sum - 1.0) < delta;
    }

    public static void shuffle(double[] arr) {
        try {
            for (int i = 0; i < arr.length - 1; i++) {
                int u = uniform(i, arr.length);
                double tmp = arr[u];
                arr[u] = arr[i];
                arr[i] = tmp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void shuffle(int[] arr) {
        try {
            for (int i = 0; i < arr.length - 1; i++) {
                int u = uniform(i, arr.length);
                int tmp = arr[u];
                arr[u] = arr[i];
                arr[i] = tmp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double sum(double[] arr) {
        double total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total;
    }

    public static double avg(double[] arr) {
        return sum(arr) / arr.length;
    }

    public static void main(String[] args) throws Exception {
        double sum = 0;
        double u;
        double[] dist = new double[100];
        for (int i = 0; i < dist.length; i++) {
            u = uniform();
            dist[i] = u;
            sum += u;
        }
        for (int i = 0; i < dist.length; i++) {
            dist[i] /= sum;
        }
        double[] origin = new double[100];
        for (int i = 0; i < 10; i++) {
            System.out.println(discrete(dist));
            origin[i] = dist[i];
        }

        testShuffle();
    }

    public static void testShuffle() throws Exception {
        int  N = 100;
        int times = 100000;
        double[] origin = new double[N];
        for (int i = 0; i < N; i++) {
            origin[i] = uniform(1000.0);
        }
        double[][] table = new double[times][N];
        for(int i = 0; i < times; i++) {
            double[] tmp = Arrays.copyOf(origin, origin.length);
            shuffle(tmp);
            table[i] = tmp;
        }

        for (int i = 0; i < N; i++) {
            double total = 0.0;
            for (int j = 0; j < times; j++) {
                total += table[j][i];
            }
            StdOut.print(total / times + "\t");
        }
        StdOut.println();

        StdOut.println(avg(origin));
    }
}
