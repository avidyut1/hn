package Contests.HourRank20;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 02/05/17
 **/
public class Pstring {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            final int MOD = (int)1e9 + 7;
            int MAX = (int)5e5 + 1;
            long fact[] = new long[MAX];
            long invFact[] = new long[fact.length];
            fact[0] = 1L;
            for (int i = 1; i < fact.length; i++) {
                fact[i] = (fact[i - 1] % MOD) * (i % MOD);
                fact[i] %= MOD;
                invFact[i] = binPow(fact[i], MOD - 2, MOD);
            }
            invFact[0] = binPow(fact[0], MOD - 2, MOD);
            long powTwo[] = new long[MAX];
            powTwo[0] = 1L;
            for (int i = 1; i < MAX; i++) {
                powTwo[i] = powTwo[i - 1] * 2L;
                powTwo[i] %= MOD;
            }
            for (int t = 0; t < tc; t++) {
                char s[] = in.readLine().toCharArray();
                int freq[] = new int[4];
                long ansab = 0L;
                long anscd = 0L;
                long ansabcd = 0L;
                for (int i = 0; i < s.length; i++) {
                    freq[s[i] - 'a']++;
                }
                for (int i = 0; i <= Math.min(freq[0], freq[1]); i++) {
                    ansab = ansab % MOD + (NCR(fact, invFact, freq[0], i, MOD) * NCR(fact, invFact, freq[1], i, MOD)) % MOD;
                }
                for (int i = 0; i <= Math.min(freq[2], freq[3]); i++) {
                    anscd = anscd % MOD + (NCR(fact, invFact, freq[2], i, MOD) * NCR(fact, invFact, freq[3], i, MOD)) % MOD;
                }
                ansabcd = (ansab % MOD * anscd % MOD) % MOD;
                ansabcd--;
                if (ansabcd < 0) {
                    ansabcd += MOD;
                }
                out.write(Long.toString(ansabcd));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static long NCR(long fact[], long invF[], long n, long r, long MOD) {
        return (fact[(int)n] * invF[(int)(n - r)] * invF[(int)r]) % MOD;
    }
    private static long binPow(long a, int b, int MOD) {
        if (a == 1 || b == 0) {
            return 1L;
        }
        long res = binPow(a, b / 2, MOD);
        res = res % MOD * res % MOD;
        if (b % 2 != 0) {
            res = res * a;
            res %= MOD;
        }
        return res % MOD;
    }
}
