package Algorithms.GraphTheory;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class FloydBlindingLights {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int m = in.readInt();
            int g[][] = new int[n][n];
            for (int i = 0; i < m; i++) {
                int u = in.readInt() - 1;
                int v = in.readInt() - 1;
                int w = in.readInt();
                g[u][v] = w;
            }
            int floyd[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(floyd[i], (int)1e5);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (g[i][j] > 0)
                    floyd[i][j] = g[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                floyd[i][i] = 0;
            }
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
                    }
                }
            }
            int q = in.readInt();
            for (int i = 0; i < q; i++) {
                int u = in.readInt() - 1;
                int v = in.readInt() - 1;
                int ans = floyd[u][v];
                if (ans == (int)1e5) {
                    ans = -1;
                }
                System.out.println(ans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
