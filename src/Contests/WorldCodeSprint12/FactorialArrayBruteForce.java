package Contests.WorldCodeSprint12;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class FactorialArrayBruteForce {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int m = in.readInt();
            int ar[] = new int[n];
            int MOD = (int)1e9;
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            for (int i = 0; i < m; i++) {
                int type = in.readInt();
                if (type == 1) {
                    int l = in.readInt() - 1;
                    int r = in.readInt() - 1;
                    for (int j = l; j <= r; j++) {
                        ar[j]++;
                    }
                }
                else if (type == 2) {
                    long ans = 0;
                    int l = in.readInt() - 1;
                    int r = in.readInt() - 1;
                    for (int j = l; j <= r; j++) {
                        long fact = 1l;
                        for (int k = 1; k <= ar[j]; k++) {
                            fact = fact * k;
                            fact %= MOD;
                        }
//                        if (fact > 0) {
//                            System.out.println("for "+ar[j]);
//                            System.out.println(fact);
//                        }
                        ans += fact;
                    }
                    out.write(Long.toString(ans % MOD));
                    out.newLine();
                }
                else {
                    int index = in.readInt() - 1;
                    int val = in.readInt();
                    ar[index] = val;
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
