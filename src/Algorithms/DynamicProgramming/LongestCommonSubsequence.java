package Algorithms.DynamicProgramming;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class LongestCommonSubsequence {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int m = in.readInt();
            int a[] = new int[n];
            int b[] = new int[m];
            for (int i = 0; i < n; i++) {
                a[i] = in.readInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.readInt();
            }
            int lcs[][] = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (i == 0 || j == 0) {
                        lcs[i][j] = 0;
                        continue;
                    }
                    if(a[i - 1] == b[j - 1]) {
                        lcs[i][j] = lcs[i -  1][j - 1] + 1;
                    }
                    else {
                        lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                    }
                }
            }
            int lcsar[] = new int[lcs[n][m]];
            int index = lcs[n][m] - 1;
            int i = n; int j = m;
            while(i > 0 && j > 0) {
                if (a[i - 1] == b[j - 1]) {
                    lcsar[index--] = a[i - 1];
                    i--; j--;
                }
                else if(lcs[i - 1][j] > lcs[i][j - 1]) {
                    i--;
                }
                else
                    j--;
            }
            for (int val: lcsar) {
                System.out.print(val+" ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
