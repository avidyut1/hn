package Algorithms.Search;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class Pairs {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int k = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            int ans = 0;
            Arrays.sort(ar);
            for (int i = 0; i < n; i++) {
                int v1 = ar[i] - k;
                int v2 = ar[i] + k;
                if (Arrays.binarySearch(ar, v1) >= 0) {
                    ans++;
                }
                if (Arrays.binarySearch(ar, v2) >= 0) {
                    ans++;
                }
            }
            System.out.println(ans / 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
