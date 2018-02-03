package Algorithms.Greedy;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class MinMax {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int k = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            Arrays.sort(ar);
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (i + k - 1 < n)
                ans = Math.min(ans, ar[i + k - 1] - ar[i]);
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
