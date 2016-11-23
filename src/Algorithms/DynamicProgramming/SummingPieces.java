package Algorithms.DynamicProgramming;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

//TODO
public class SummingPieces {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            final int MOD = (int)1e9 + 7;
            int ar[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                ar[i] = in.readInt();
            }
            int sum[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sum[i] += (i - 1 >= 0) ? sum[i - 1] : 0;
                sum[i] += ar[i];
            }
            int dp[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i ; j++) {
                    int val = (i - j) * (sum[i] - sum[j - 1]);
                    System.out.println(val);
                    dp[i] += dp[j] + val;
                }
            }
            System.out.println(Arrays.toString(sum));
            System.out.println(Arrays.toString(dp));
            System.out.println(dp[n]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
