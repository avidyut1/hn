package Contests.HourRank24;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class MutualIndivisibility {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int MAX = (int)1e4 + 1;
            Vector<Integer> dpf[] = new Vector[MAX];
            for (int i = 0; i < MAX; i++) {
                dpf[i] = new Vector<>();
            }
            HashSet<Integer> allPrimes = new HashSet<>();
            boolean isprime[] = new boolean[MAX];
            Arrays.fill(isprime, true);
            isprime[0] = isprime[1] = false;
            for (int i = 0; i < MAX; i++) {
                if (isprime[i]) {
                    allPrimes.add(i);
                    for (int j = 0; j < MAX; j+=i) {
                        dpf[j].add(i);
                        isprime[j] = false;
                    }
                }
            }
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int a = in.readInt();
                int b = in.readInt();
                int x = in.readInt();
                HashSet<Integer> dpfUsed = new HashSet<>();
                HashSet<Integer> ans = new HashSet<>();
                if (a == 1) {
                    a++;
                }
                for (int i = a; i <= b; i++) {
                    boolean canTake = true;
                    for (int dpfactor: dpf[i]) {
                        if (dpfUsed.contains(dpfactor)) {
                            canTake = false;
                            break;
                        }
                    }
                    if (canTake) {
                        dpfUsed.addAll(dpf[i]);
                        ans.add(i);
                    }
                    if (ans.size() == x) {
                        break;
                    }
                }
                if (ans.size() != x) {
                    for (int prime: allPrimes) {
                        if (dpfUsed.contains(prime)) {
                            continue;
                        }
                        int times = a / prime;
                        int num = times * prime;
                        while(num < a) {
                            num += a;
                        }
                        for (int i = num; i <= b; i+=prime) {
                            dpfUsed.add(prime);
                            ans.add(num);
                            if (ans.size() == x) {
                                break;
                            }
                        }
                        if (ans.size() == x) {
                            break;
                        }
                    }
                }
                if (ans.size() == x) {
                    for (int val : ans) {
                        out.write(Integer.toString(val)+" ");
                    }
                }
                else {
                    out.write(Integer.toString(-1));
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
