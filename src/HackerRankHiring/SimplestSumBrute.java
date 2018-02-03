package HackerRankHiring;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class SimplestSumBrute {
    public static int MOD = (int)1e9 + 7;
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int q = in.readInt();
            for (int qc = 0; qc < q; qc++) {
                int k = in.readInt();
                int a = in.readInt();
                int b = in.readInt();
                long s = 0L;
                long oneToBe = 0;
                for (int i = 1; i <= b; i++) {
                    oneToBe += f(i, k);
                }
                System.out.println(oneToBe);
                for (int n = a; n <= b; n++) {
                    long res = f(n, k);
                    s += res;
                    s %= MOD;
                }
                out.write(Long.toString(s));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static long f(int n, int k) {
        long sum = 0;

        for (int i = 1; i <= n; i += 1) {
            sum += i;
            sum %= MOD;
            i *= k;
        }

        return sum;
    }
}
