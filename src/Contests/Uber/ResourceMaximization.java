package Contests.Uber;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 14/05/17
 **/
public class ResourceMaximization {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int r = in.readInt();
                int c = in.readInt();
                int resourceA[][] = new int[r][c];
                int resourceB[][] = new int[r][c];
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        resourceA[i][j] = in.readInt();
                    }
                }
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        resourceB[i][j] = in.readInt();
                    }
                }
                int sumA1[] = new int[r];
                int sumB1[] = new int[r];
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        sumA1[i] += resourceA[i][j];
                        sumB1[i] += resourceB[i][j];
                    }
                    if (i - 1 >= 0) {
                        sumA1[i] += sumA1[i - 1];
                        sumB1[i] += sumB1[i - 1];
                    }
                }
                int sumA2[] = new int[r];
                int sumB2[] = new int[r];
                for (int i = r - 1; i >= 0; i--) {
                    for (int j = 0; j < c; j++) {
                        sumA2[i] += resourceA[i][j];
                        sumB2[i] += resourceB[i][j];
                    }
                    if (i + 1 < r) {
                        sumB2[i] += sumB2[i + 1];
                        sumA2[i] += sumA2[i + 1];
                    }
                }
                int ans1 = Integer.MIN_VALUE;
                int ans2 = Integer.MIN_VALUE;
                for (int i = 0; i < r; i++) {
                    if (i + 1 < r) {
                        ans1 = Math.max(ans1, sumB1[i] + sumA2[i + 1]);
                        ans2 = Math.max(ans2, sumA1[i] + sumB2[i + 1]);
                    }
                    else {
                        ans1 = Math.max(ans1, sumB1[i]);
                        ans2 = Math.max(ans2, sumB2[i]);
                    }
                }
                out.write(Integer.toString(Math.max(ans1, ans2)));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
