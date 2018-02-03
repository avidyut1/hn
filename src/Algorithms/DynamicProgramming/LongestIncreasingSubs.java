package Algorithms.DynamicProgramming;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class LongestIncreasingSubs {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            int lis[] = Lis2.lis(ar);
            System.out.println(lis.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Lis2 {

    public static int[] lis(int[] a) {
        int n = a.length;
        int[] tail = new int[n];
        int[] prev = new int[n];

        int len = 0;
        for (int i = 0; i < n; i++) {
            int pos = lower_bound(a, tail, len, a[i]);
            if (pos == len) {
                ++len;
            }
            prev[i] = pos > 0 ? tail[pos - 1] : -1;
            tail[pos] = i;
        }

        int[] res = new int[len];
        for (int i = tail[len - 1]; i >= 0; i = prev[i]) {
            res[--len] = a[i];
        }
        return res;
    }

    static int lower_bound(int[] a, int[] tail, int len, int key) {
        int lo = -1;
        int hi = len;
        while (hi - lo > 1) {
            int mid = (lo + hi) >>> 1;
            if (a[tail[mid]] < key) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }
}
