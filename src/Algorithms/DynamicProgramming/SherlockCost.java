package Algorithms.DynamicProgramming;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class SherlockCost {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int t = in.readInt();
            for (int tc = 0; tc < t; tc++) {
                int n = in.readInt();
                int ar[] = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = in.readInt();
                }
                int dp[][] = new int[n + 1][2];
                for (int i = 0; i < n - 1; i++) {
                    dp[i + 1][0] = Math.max(dp[i][0] + 1 - 1, dp[i][1] + Math.abs(ar[i] - 1));
                    dp[i + 1][1] = Math.max(dp[i][0] + Math.abs(ar[i + 1] - 1), dp[i][1] + Math.abs(ar[i + 1] - ar[i]));
                }
                System.out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
