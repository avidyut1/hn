package Contests.Week27;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class Taylor {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int p = in.readInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.readInt();
            }
            long ans = 0l;
            Vector<Integer> v = new Vector<>();
            for (int i = 0; i < n; i++) {
                int q = a[i] / p;
                if (a[i] % p != 0) {
                    q++;
                }
                v.add(q);
            }
            Collections.sort(v);
            int ar[] = new int[v.size()];
            for (int i = 0; i < n; i++) {
                ar[i] = v.get(i);
            }
            for (int i = 1; i < n; i++) {
                if (ar[i] <= ar[i - 1]) {
                    ar[i] = ar[i - 1] + 1;
                }
            }
            for (int i = 0; i < n; i++) {
                ans += ar[i];
            }
            out.write(Long.toString(ans));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
