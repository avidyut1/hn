package Contests.Week28;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class LuckyNumberEight {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int ar[] = new int[n];
            String inp = in.readLine();
            for (int i = 0; i < n; i++) {
                ar[i] = Integer.parseInt(Character.toString(inp.charAt(i)));
            }
            final int MOD = (int)1e9 + 7;
            int dp[][] = new int[n][8];
            dp[0][0] = 1;
            dp[0][ar[0] % 8] += 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 8; j++) {
                    dp[i][j] = dp[i - 1][j] % MOD;
                    dp[i][j] %= MOD;
                }
                for (int j = 0; j < 8; j++) {
                    dp[i][((j * 10) + ar[i]) % 8] += (dp[i - 1][j] % MOD);
                    dp[i][((j * 10) + ar[i]) % 8] %= MOD;
                }
            }
            out.write(Integer.toString((dp[n - 1][0] - 1) % MOD));
            out.newLine();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
