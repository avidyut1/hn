package Contests.Week26;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class Twins {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int MAX = (int)1e6 + 1;
            boolean isprime[] = new boolean[MAX];
            Arrays.fill(isprime, true);
            isprime[0] = false;
            isprime[1] = false;
            for (int i = 2; i < MAX; i++) {
                if (isprime[i]) {
                    for (int j = 2 * i; j < MAX; j+=i) {
                        isprime[j] = false;
                    }
                }
            }
            int n = in.readInt();
            int m = in.readInt();
            boolean res[] = new boolean[m - n + 1];
            Arrays.fill(res, true);
            for (int i = 2; i < MAX; i++) {
                if(isprime[i]) {
                    int d = n / i;
                    d = d * i;
                    if(d < n) {
                        d += i;
                    }
                    if(d == i) {
                        d += i;
                    }
                    for (int j = d; j < m + 1; j+=i) {
                        res[j - n] = false;
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < res.length; i++) {
                if(i + 2 < res.length && res[i] && res[i + 2]) {
                    ans++;
                }
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

