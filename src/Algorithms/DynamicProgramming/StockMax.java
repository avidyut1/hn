package Algorithms.DynamicProgramming;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class StockMax {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int t = in.readInt();
            for (int tc = 0; tc < t; tc++) {
                int n = in.readInt();
                int ar[] = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = in.readInt();
                }
                long ans[] = new long[n];
                ans[0] = 0l;
                for (int i = 1; i < n; i++) {
                    int j = i - 1;
                    long buy = 0l;
                    for (;j >= 0; j--) {
                        if(ar[j] > ar[i]){
                            break;
                        }
                        buy += ar[j];
                    }
                    int pa = j;
                    if(j < 0){
                        pa = 0;
                    }
                    long profit = (i - j - 1) * (long)ar[i];
                    ans[i] = ans[pa] + (profit - buy);
                }
                out.write(Long.toString(ans[n - 1]));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

