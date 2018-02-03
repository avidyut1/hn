package Contests.Hack10143;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class Xorpoint {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int m = in.readInt();
            int r = in.readInt();
            long ans = 0l;
            int war[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    war[i][j] = in.readInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    long tweight = 0l;
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < m; l++) {
                            if (incircle(i, j, r, k, l)) {
                                tweight += war[k][l];
                            }
                        }
                    }
                    ans = ans ^ tweight;
                }
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean incircle(int x, int y, int r, int a, int b) {
        if (Math.pow(a - x, 2) + Math.pow(b - y, 2) <= Math.pow(r, 2)) {
            return true;
        }
        return false;
    }
}
