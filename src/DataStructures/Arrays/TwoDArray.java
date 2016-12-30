package DataStructures.Arrays;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class TwoDArray {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = 6;
            int ar[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ar[i][j] = in.readInt();
                }
            }
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j + 3 <= n && i + 2 < n) {
                        int sum = 0;
                        for (int k = j; k < j + 3; k++) {
                            sum += ar[i][k];
                        }
                        sum += ar[i + 1][j + 1];
                        for (int k = j; k < j + 3; k++) {
                            sum += ar[i + 2][k];
                        }
                        ans = Math.max(ans, sum);
                    }
                }
            }
            out.write(Integer.toString(ans));
            out.newLine();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
