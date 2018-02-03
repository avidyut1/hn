package HackerRankHiring;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class SimplestSum {
    public static int MOD = (int)1e9 + 7;
    final static int MAX = (int)1e5 + 1;
    private static HashMap<Long, Long> solution[] = new HashMap[MAX];
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < MAX; i++) {
                solution[i] = new HashMap<>();
            }
            long st = System.currentTimeMillis();
            for (int k = 2; k < MAX; k++) {
                f((long)1e18, k);
            }
            long et = System.currentTimeMillis();
            System.out.println(et - st);
            int q = in.readInt();
            for (int qc = 0; qc < q; qc++) {
                int k = in.readInt();
                long a = in.readLong();
                long b = in.readLong();
//                ans %= MOD;
//                out.write(Long.toString(ans));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void f(long n, int k) {
        System.out.println(k);
        long res = 1L;
        long num = (long)k;
        long expo = (long)k * k;
        long ans = (long)k;
        while(num <= n) {
            if (num < 0) {
                break;
            }
            long prevNum = num;
            res = num + res + 1;
            num = num + expo;
            expo *= k;
            ans += (Math.min(num, n) % MOD - prevNum % MOD) * (res % MOD);
            solution[k].put(num, ans);
        }
    }
}
