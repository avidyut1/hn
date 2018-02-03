package Contests.WorldCodeSprint12;

import Algorithms.InputReader;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.util.*;
import java.math.*;

public class FactorialArray {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int fact = 1;
            int MAX = 40;
            int factAr[] = new int[MAX];
            int MOD = (int)1e9;
            for (int i = 1; i < MAX; i++) {
                fact = (int)(((long)fact * i) % MOD);
                fact %= MOD;
                factAr[i] = fact;
            }
            int n = in.readInt();
            int m = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            int SQRT = ((int)Math.sqrt((double)n)) + 1;
            int freq[][] = new int[SQRT][MAX];
            for (int i = 0; i < n; i++) {
                int blockNumber = i / SQRT;
                if (ar[i] < MAX) {
                    freq[blockNumber][ar[i]]++;
                }
            }
            int update[] = new int[SQRT];
            for (int i = 0; i < m; i++) {
                int type = in.readInt();
                if (type == 1) {
                    int l = in.readInt() - 1;
                    int r = in.readInt() - 1;
                    if (l / SQRT == r / SQRT) {
                        for (int j = l; j <= r; j++) {
                            if (ar[j] + update[l / SQRT] < MAX) {
                                freq[l / SQRT][ar[j]]--;
                            }
                            if (ar[j] + update[l / SQRT] + 1 < MAX) {
                                freq[l / SQRT][ar[j] + 1]++;
                            }
                            ar[j]++;
                        }
                    }
                    else {
                        int startBlock = (l / SQRT) * SQRT;
                        int endBlock = startBlock + SQRT - 1;
                        for (int j = l; j <= endBlock; j++) {
                            if (ar[j] + update[l / SQRT]< MAX) {
                                freq[l / SQRT][ar[j]]--;
                            }
                            if (ar[j] + update[l / SQRT]+ 1 < MAX) {
                                freq[l / SQRT][ar[j] + 1]++;
                            }
                            ar[j]++;
                        }
                        for (int j = (l / SQRT) + 1; j < r / SQRT; j++) {
                            for (int k = MAX - 1; k > 0; k--) {
                                freq[j][k] = freq[j][k - 1];
                            }
                            freq[j][0] = 0;
                            update[j]++;
                        }
                        startBlock = (r / SQRT) * SQRT;
                        for (int j = startBlock; j <= r; j++) {
                            if (ar[j] + update[r / SQRT]< MAX) {
                                freq[r / SQRT][ar[j]]--;
                            }
                            if (ar[j] + update[r / SQRT]+ 1 < MAX) {
                                freq[r / SQRT][ar[j] + 1]++;
                            }
                            ar[j]++;
                        }
                    }
                }
                else if (type == 2) {
                    int l = in.readInt() - 1;
                    int r = in.readInt() - 1;
                    long qans = 0L;
                    if (l / SQRT == r /  SQRT) {
                        for (int j = l; j <= r; j++) {
                            if (ar[j] + update[l / SQRT] < MAX) {
                                qans += factAr[ar[j]] % MOD;
                            }
                        }
                    }
                    else {
                        int startBlock = (l / SQRT) * SQRT;
                        int endBlock = startBlock + SQRT - 1;
                        for (int j = l; j <= endBlock; j++) {
                            if (ar[j]+ update[l / SQRT] < MAX) {
                                qans += factAr[ar[j]] % MOD;
                                qans %= MOD;
                            }
                        }
                        for (int j = (l / SQRT) + 1; j < (r / SQRT); j++) {
                            for (int k = 0; k < MAX; k++) {
                                qans += ((long)factAr[k] * freq[j][k]);
                                qans %= MOD;
                            }
                        }
                        startBlock = (r / SQRT) * SQRT;
                        for (int j = startBlock; j <= r; j++) {
                            if (ar[j] + update[r / SQRT] < MAX) {
                                qans += factAr[ar[j] + update[r / SQRT]];
                                qans %= MOD;
                            }
                        }
                    }
                    while (qans < 0){
                        qans += MOD;
                    }
                    out.write(Long.toString(qans % MOD));
                    out.newLine();
                }
                else {
                    int index = in.readInt() - 1;
                    int val = in.readInt();
                    int blockNumber = index / SQRT;
                    if (ar[index] + update[blockNumber] < MAX) {
                        freq[blockNumber][ar[index] + update[blockNumber]]--;
                    }
                    if (val < MAX) {
                        freq[blockNumber][val]++;
                    }
                    ar[index] = val;
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
