package Algorithms.Search;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class SherlockArray {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                int ar[] = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = in.readInt();
                }
                int lefs[] = new int[n];
                for (int i = 0; i < n; i++) {
                    lefs[i] = i - 1 >= 0 ? lefs[i - 1] : 0;
                    lefs[i] += ar[i];
                }
                int rigs[] = new int[n];
                for (int i = n - 1; i >= 0; i--) {
                    rigs[i] = i + 1 < n ? rigs[i + 1] : 0;
                    rigs[i] += ar[i];
                }
                boolean ans = false;
                for (int i = 0; i < n; i++) {
                    if(lefs[i] == rigs[i]) {
                        ans = true;
                        System.out.println("YES");
                        break;
                    }
                }
                if (!ans) {
                    System.out.println("NO");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
