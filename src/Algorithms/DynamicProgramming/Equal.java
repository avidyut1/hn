package Algorithms.DynamicProgramming;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class Equal {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int t = in.readInt();
            for (int tc = 0; tc < t; tc++) {
                int n = in.readInt();
                int ar[] = new int[n];
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    ar[i] = in.readInt();
                    min = Math.min(min, ar[i]);
                }
                int ans = Integer.MAX_VALUE;
                for (int i = min; i >= min - 5; i--) {
                    int lans = 0;
                    for (int j = 0; j < n; j++) {
                        int diff = Math.abs(ar[j] - i);
                        lans += (diff/5) + ((diff%5)/2) + ((diff%5)%2);
                    }
                    ans = Math.min(lans, ans);
                }
                out.write(Integer.toString(ans));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

