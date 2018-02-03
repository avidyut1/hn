package Algorithms.Greedy;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class MarkToys {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            long k = in.readLong();
            long ar[] = new long[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readLong();
            }
            Arrays.sort(ar);
            int count = 0;
            long total = 0l;
            for (int i = 0; i < n; i++) {
                if (total + ar[i] <= k) {
                    total += ar[i];
                    count++;
                }
                else
                    break;
            }
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
