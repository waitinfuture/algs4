package chapter1;

import chapter1.base.ArrUtil;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 周克勇 on 2018/4/30.
 */
public class Dice {
    private int diceNum, faceNum;
    private double[] prob;

    public Dice(int diceNum, int faceNum) {
        this.diceNum = diceNum;
        this.faceNum = faceNum;
        prob = new double[diceNum * faceNum - diceNum + 1];
        for (int i = 0; i < prob.length; i++) {
            prob[i] = 0;
        }
    }

    public int index(int sum) {
        return sum - diceNum;
    }

    // pow(n, m)
    public void pow() {
        int[] arr = new int[diceNum];
        for (int i = 0; i < diceNum; i++) {
            arr[i] = 1;
        }

        pow(0, faceNum, arr);
    }

    public void pow(int cur, int max, int[] arr) {
        if (cur == arr.length) {
            StdOut.println(arr, arr.length);
            prob[index(ArrUtil.sum(arr))]++;
            return;
        }

        for (int i = 1; i <= max; i++) {
            int tmp = arr[cur];
            arr[cur] = i;
            pow(cur + 1, max, arr);
            arr[cur] = tmp;
        }
    }

    public void norm() {
        ArrUtil.norm(prob);
    }

    public void showProb() {
        StdOut.println(prob, prob.length);
    }

    public static void main(String[] args) {
        Dice dice = new Dice(2, 6);
        dice.pow();
        dice.norm();
        dice.showProb();
    }
}
