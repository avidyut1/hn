package Contests.HourRank26;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class CloudyDay {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            long p[] = new long[n];
            long totalPopulation = 0L;
            for (int i = 0; i < n; i++) {
                p[i] = in.readLong();
                totalPopulation += p[i];
            }
            long x[] = new long[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.readLong();
            }
            int m = in.readInt();
            long y[] = new long[m];
            for (int i = 0; i < m; i++) {
                y[i] = in.readLong();
            }
            Range[] cloudeRange = new Range[m];
            for (int i = 0; i < m; i++) {
                int r = in.readInt();
                cloudeRange[i] = new Range(y[i] - r, y[i] + r);
            }
            IntervalSearchTree intervalSearchTree = new IntervalSearchTree();
            for (int i = 0; i < cloudeRange.length; i++) {
                intervalSearchTree.insert(cloudeRange[i].l, cloudeRange[i].r, i);
            }
            HashMap<Integer, Long> cloudIndex = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int cloudIds[] = intervalSearchTree.query(x[i]);
                if (cloudIds[1] != -7 && cloudIds[0] != -7) {
                    totalPopulation -= p[i];
                }
                else if (cloudIds[1] != -7){
                    cloudIndex.put(cloudIds[1], cloudIndex.containsKey(cloudIds[1]) ? cloudIndex.get(cloudIds[1]) + p[i] : p[i]);
                }
            }
            Vector<Long> populations = new Vector<>(cloudIndex.values());
            Collections.sort(populations);
            for (int i = 0; i < populations.size() - 1; i++) {
                totalPopulation -= populations.get(i);
            }
            out.write(Long.toString(totalPopulation));
            out.newLine();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Range implements Comparable<Range>{
        long l, r;

        public Range(long l, long r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Range o) {
            return Long.compare(this.r - this.l, o.r - o.l);
        }
    }
    private static class IntervalSearchTreeNode {
        public long l, r;
        public int index;
        public long maxBelow;
        public long minBelow;
        public IntervalSearchTreeNode left;
        public IntervalSearchTreeNode right;

        public IntervalSearchTreeNode(int index, long l, long r) {
            this.l = l;
            this.index = index;
            this.r = r;
            this.maxBelow = r;
            this.minBelow = l;
        }

    }
    public static class IntervalSearchTree {
        IntervalSearchTreeNode root;

        public IntervalSearchTree() {
            root = null;
        }

        public void insert(long l, long r, int id){
            root = put(root, l, r, id);
        }
        public IntervalSearchTreeNode put(IntervalSearchTreeNode node, long l, long r, int id){
            if(node == null){
                node = new IntervalSearchTreeNode(id, l, r);
                return node;
            }
            if(node.l > l){
                node.left = put(node.left, l, r, id);
            }
            else {
                node.right = put(node.right, l, r, id);
            }
            node.maxBelow = Math.max(r, node.maxBelow);
            node.minBelow = Math.min(l, node.minBelow);
            return node;
        }
        public int[] query(long x) {
            return queryTree(x, root);
        }
        private int[] queryTree(long val, IntervalSearchTreeNode node) {
            if (node == null) {
                return new int[]{-7, -7};
            }
            if (node.maxBelow < val) {
                return new int[]{-7, -7};
            }
            int[] retVal = new int[2];
            Arrays.fill(retVal, -7);
            if (node.l <= val && node.r >= val) {
                retVal[1] = node.index;
            }
            int [] left = new int[]{-7, -7};
            if (node.left != null && node.left.maxBelow >= val && node.left.minBelow <= val) {
                left = queryTree(val, node.left);
            }
            int vals[] = new int[4];
            for (int i = 0; i < 2; i++) {
                vals[i] = left[i];
                vals[i + 2] = retVal[i];
            }
            Arrays.sort(vals);
            if (vals[2] != -7 && vals[3] != -7) {
                return new int[]{vals[2], vals[3]};
            }
            int [] right = new int[]{-7, -7};
            if (node.right != null && node.right.maxBelow >= val && node.right.minBelow <= val) {
                right = queryTree(val, node.right);
            }
            int newAr[] = new int[6];
            newAr[0] = retVal[0];
            newAr[1] = retVal[1];
            for (int i = 0; i < 2; i++) {
                newAr[i + 2] = left[i];
                newAr[i + 4] = right[i];
            }
            Arrays.sort(newAr);
            return new int[]{newAr[4], newAr[5]};
        }
    }
}



