package Contests.Week28;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class GreatXor {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            final int MAX = 40;
            long pow2[] = new long[MAX];
            pow2[0] = 1l;
            for (int i = 1; i < MAX; i++) {
                pow2[i] = 2l * pow2[i - 1];
            }
            int q = in.readInt();
            for (int qc = 0; qc < q; qc++) {
                long x = in.readLong();
                int ind = Arrays.binarySearch(pow2, x);
                if (ind < 0) {
                    ind = -1 -ind;
                    ind--;
                    long ansind = pow2[ind] - 1;
                    long diff = x - pow2[ind];
                    out.write(Long.toString(ansind - diff));
                }
                else {
                    out.write(Long.toString(x - 1));
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
