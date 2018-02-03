package Contests.WorldCodeSprint10;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 28/04/17
 **/
public class MaximalAND {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            final int maxBit = 64;
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int k = in.readInt();
            Long ar[] = new Long[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readLong();
            }
            long max = 0;
            long maxCount = 0;
            for (int mask = 0; mask < 1 << n; mask++) {
                int count = 0;
                long ans = 0;
                for (int bit = 0; bit < n; bit++) {
                    if ((mask & 1 << bit) != 0) {
                        if (ans == 0) {
                            ans = ar[bit];
                        }
                        else {
                            ans &= ar[bit];
                        }
                        count++;
                    }
                }
                if (count == k) {
                    if (ans > max) {
                        maxCount = 1;
                        max = ans;
                    }
                    else if (ans == max) {
                        maxCount++;
                    }
                }
            }
            out.write(Long.toString(max));
            out.newLine();
            out.write(Long.toString(maxCount));
            out.newLine();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


