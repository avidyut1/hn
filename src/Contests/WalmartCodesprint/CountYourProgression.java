package Contests.WalmartCodesprint;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class CountYourProgression {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            int dp[][] = new int[n][201];
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int cd = ar[j] - ar[i];
                    dp[j][cd]++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
