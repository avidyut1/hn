package Contests.Hack10143;
import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class MinSum {
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
            long ans = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (i + k - 1 < n) {
                    int b[] = new int[k];
                    int ind = 0;
                    for (int j = i; j <= i + k - 1; j++) {
                        b[ind++] = ar[j];
                    }
                    long lans = 0;
                    for (int l = 0; l <= k - 1; l++) {
                        for (int m = l + 1; m <= k - 1; m++) {
                            lans += Math.pow(b[l] - b[m], 2);
                        }
                    }
                    lans *= 2;
                    ans = Math.min(lans, ans);
                }
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
