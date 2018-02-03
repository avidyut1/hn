package Contests.HourRank19;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 02/04/17
 **/
public class WhatAreTheOdds {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            int xor = 0;
            for (int i = 0; i < n; i++) {
                xor = xor ^ ar[i];
            }
            int ans = 0;
            int xorFront[] = new int[n];
            int xorBack[] = new int[n];
            for (int i = 0; i < n; i++) {
                xorFront[i] = ar[i];
                xorFront[i] = xorFront[i] ^ (i - 1 >= 0 ? xorFront[i - 1] : 0);
            }
            for (int i = n - 1; i >= 0; i--) {
                xorBack[i] = ar[i];
                xorBack[i] = xorBack[i] ^ (i + 1 < n ? xorBack[i + 1] : 0);
            }
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int resxor = xor ^ (xor ^ (i - 1 >= 0 ? xorFront[i - 1] : 0) ^ (j + 1 < n ? xorBack[j + 1]: 0));
                    if (resxor == 0) {
                        ans++;
                        j++;
                    }
                }
            }
            out.write(Integer.toString(ans));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
