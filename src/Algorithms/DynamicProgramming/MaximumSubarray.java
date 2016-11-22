package Algorithms.DynamicProgramming;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class MaximumSubarray {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                int ar[] = new int[n];
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    ar[i] = in.readInt();
                    if (ar[i] > 0) {
                        sum += ar[i];
                    }
                }
                if (sum == 0) {
                    sum = ar[0];
                    for (int i = 0; i < n; i++) {
                        sum = Math.max(sum, ar[i]);
                    }
                }
                int maxeh = ar[0]; int maxsf = ar[0];
                for (int i = 1; i < n; i++) {
                    maxeh = Math.max(ar[i], ar[i] + maxeh);
                    maxsf = Math.max(maxeh, maxsf);
                }
                System.out.println(maxsf+" "+sum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
