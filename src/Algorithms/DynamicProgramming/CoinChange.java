package Algorithms.DynamicProgramming;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;

public class CoinChange {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int m = in.readInt();
            int c[] = new int[m];
            for (int i = 0; i < m; i++) {
                c[i] = in.readInt();
            }
            Arrays.sort(c);
            int ans[] = new int[n + 1];
            ans[0] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = c[i]; j < n + 1; j++) {
                    ans[j] += ans[j - c[i]];
                }
            }
            out.write(Long.toString(ans[n]));
            out.newLine();out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

