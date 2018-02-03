package HackerRankHiring;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class SimplestSumTLE {
    public static int MOD = (int)1e9 + 7;
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int q = in.readInt();
            for (int qc = 0; qc < q; qc++) {
                int k = in.readInt();
                long a = in.readLong();
                long b = in.readLong();
                long ans = f(b, k) - f(a - 1, k);
                ans %= MOD;
                while(ans < 0) {
                    ans += MOD;
                }
                out.write(Long.toString(ans % MOD));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static long f(long n, int k) {
        if (n <= k) {
            return n;
        }
        long res = 1L;
        long num = (long)k;
        long expo = (long)k * k;
        long ans = (long)k;
        int count = 1;
        while(num <= n) {
            long prevNum = num;
            res = num + res + 1;
            num = num + expo;
            count++;
            if (count >= 64) {
                break;
            }
            expo = expo * k;
            long valueToAdd = Math.min(num, n) - prevNum;
            valueToAdd = mulmod2(valueToAdd, res, MOD);
            ans += valueToAdd;
            ans %= MOD;
        }
        return ans % MOD;
    }
    private static long mulmod2(long a, long b, long c){
        if(b == 0){
            return 0l;
        }
        long res = mulmod2(a, b >> 1, c);
        res %= c;
        res = (res % c + res % c) % c;
        if((b & 1) == 1){
            //if b is odd then we express it as a * b = a+ a * (b>>1).
            // We have computed a*(b>>1) in the previous step by recursion
            // i.e the value ret. We now add the extra a to it.
            res = (res % c + a % c) % c;
        }
        return res % c;
    }
}
