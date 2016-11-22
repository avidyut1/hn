package Algorithms.DynamicProgramming;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class MandograForest {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                long h[] = new long[n];
                for (int i = 0; i < n; i++) {
                    h[i] = in.readLong();
                }
                Arrays.sort(h);
                long ans = Long.MIN_VALUE;
                long backsum[] = new long[n];
                for (int i = n -1; i >= 0; i--) {
                    backsum[i] = i + 1 < n ? backsum[i + 1] : 0;
                    backsum[i] += h[i];
                }
                for (int i = 0; i < n; i++) {
                    ans = Math.max((i + 1) * backsum[i], ans);
                }
                System.out.println(ans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
