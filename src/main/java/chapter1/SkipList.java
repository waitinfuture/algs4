package chapter1;

import chapter1.base.ArrUtil;
import chapter1.base.StdRandom;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 周克勇 on 2018/4/30.
 * not support same key
 */
public class SkipList {
    class Node {
        Node left;
        Node right;
        Node down;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    List<Node> heads;
    int levels;

    public SkipList() {
        heads = new LinkedList();
        heads.add(new Node(Integer.MIN_VALUE));
        levels = 1;
    }

    public void insert(int a) {
        List<Node> traceNodes = searchInternal(a);
        Node left = traceNodes.get(0);
        // return if key exists
        if (left.value == a) {
            return;
        }
        Node right = traceNodes.get(0).right;
        Node newNode = new Node(a);
        left.right = newNode;
        newNode.right = right;
        newNode.left = left;
        if (right != null) {
            right.left = newNode;
        }

        int nextLevel = 1;
        while (shouldPromote()) {
            Node newNodeUp = new Node(a);
            newNodeUp.down = newNode;
            if (nextLevel >= levels) {
                Node newHead = new Node(Integer.MIN_VALUE);
                newHead.down = heads.get(levels - 1);
                heads.add(newHead);
                levels++;
                newHead.right = newNodeUp;
                newNodeUp.left = newHead.right;
            } else {
                Node newLeft = traceNodes.get(nextLevel);
                newNodeUp.right = newLeft.right;
                if (newLeft.right != null) {
                    newLeft.right.left = newNodeUp;
                }
                newNodeUp.left = newLeft;
                newLeft.right = newNodeUp;
            }

            nextLevel++;
            newNode = newNodeUp;
        }
    }

    private boolean shouldPromote() {
        return StdRandom.uniform() < 0.5;
    }

    public void delete(int a) {
        List<Node> traceNodes = searchInternal(a);
        for (int i = 0; i < traceNodes.size(); i++) {
            if (traceNodes.get(0).value != a) {
                continue;
            }
            Node left = traceNodes.get(0).left;
            Node right = traceNodes.get(0).right;
            left.right = right;
            if (right != null) {
                right.left = left;
            }
        }
    }

    private List<Node> searchInternal(int val) {
        List<Node> trace = new LinkedList<>();
        Node cur = heads.get(levels - 1);
        for (int level = levels - 1; level >= 0; level--) {
            while (cur.right != null && cur.right.value <= val) {
                cur = cur.right;
            }
            trace.add(0, cur);
            cur = cur.down;
        }

        return trace;
    }

    public Node search(int val) {
        List<Node> trace = searchInternal(val);
        return trace.get(0);
    }

    public void print() {
        for (int i = levels - 1; i >= 0; i--) {
            Node cur = heads.get(i);
            while (cur != null) {
                StdOut.printf("%d<-->", cur.value);
                cur = cur.right;
            }
            StdOut.println();
        }
    }

    public static void main(String[] args) throws Exception {
        SkipList skipList = new SkipList();
        int N = 10000;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
        StdRandom.shuffle(arr);
        for (int i = 0; i < N; i++) {
            skipList.insert(arr[i]);
        }

        for (int i = 0; i < 1000; i++) {
            int val = StdRandom.nextInt(N);
            if (val != skipList.search(val).value) {
                throw new Exception("not eq");
            }
        }

        int M = 1000;
        /*
        int[] list = new int[M];
        for (int i = 0; i < M; i++) {
            list[i] = StdRandom.nextInt(N);
        }
        for (int i = 0; i < list.length; i++) {
            skipList.delete(list[i]);
        }
        */

        List<Integer> list = new ArrayList();
        for (int i = 0; i < M; i++) {
            list.add(StdRandom.nextInt(N));
        }
        for (int i = 0; i < list.size(); i++) {
            skipList.delete(list.get(i));
        }

        StdOut.println("=====================");

        skipList.print();
        StdOut.println(list);

        for (int i = 0; i < 2000; i++) {
            int val = StdRandom.nextInt(N);
            if (ArrUtil.contains(list, val)) {
                continue;
            }
            int searchVal = skipList.search(val).value;
            if (val != searchVal) {
                throw new Exception("not eq" + val + "\t" + skipList.search(val).value);
            }
        }

        skipList.print();
    }
}
