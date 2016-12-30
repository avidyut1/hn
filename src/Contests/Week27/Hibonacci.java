package Contests.Week27;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class Hibonacci {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int q = in.readInt();
            final int MAX = (int)4e6 + 1;
            final int MOD = 10;
            long h[] = new long[MAX];
            h[1] = 1;
            h[2] = 2;
            h[3] = 3;
            for (int i = 4; i < MAX; i++) {
                h[i] = h[i - 1] + (2 * h[i - 2]) + (3 * h[i - 3]);
                h[i] %= MOD;
            }
            int g[][] = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (h[(int)Math.pow(i * j, 2)] % 2 == 0) {
                        g[i][j] = 1;
                    }
                    else{
                        g[i][j] = 0;
                    }
                }
            }
            int grid[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = g[i + 1][j + 1];
                }
            }
            for (int qc = 0; qc < q; qc++) {
                int angle = in.readInt();
                int times = angle / 90;
                times %= 4;
                int gr[][] = grid;
                for (int i = 0; i < times; i++) {
                    gr = rotate90Clockwise(gr);
                }
                int ans = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if(gr[i][j] != grid[i][j]) {
                            ans++;
                        }
                    }
                }
                out.write(Integer.toString(ans));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int [][] rotate90Clockwise(int g[][]) {
        int n = g.length;
        int res[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nr = j;
                int nc = n - i - 1;
                res[nr][nc] = g[i][j];
            }
        }
        return res;
    }
}
