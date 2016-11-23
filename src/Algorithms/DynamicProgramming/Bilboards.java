package Algorithms.DynamicProgramming;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class Bilboards {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int k = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            long dp[] = new long[n];
            for (int i = 0; i < n; i++) {
                dp[i] = (long)ar[i];
                if (i - 2 >= 0) {
                    dp[i] += dp[i - 2];
                }
                int sum = ar[i];
                for (int j = i - 1; j >= Math.max(0, i - k + 1); j--) {
                    sum += ar[j];
                    dp[i] = Math.max(dp[i], sum + (j - 2 >= 0 ? dp[j - 2] : 0));
                }
            }
            long max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, dp[i]);
            }
            System.out.println(max);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
