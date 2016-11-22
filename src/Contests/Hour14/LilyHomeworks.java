package Contests.Hour14;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;
public class LilyHomeworks {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            long ar[] = new long[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readLong();
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                int min_ind = minindex(i, ar);
                if (min_ind != i) {
                    long temp = ar[min_ind];
                    ar[min_ind] = ar[i];
                    ar[i] = temp;
                    count++;
                }
            }
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int minindex(int x, long ar[]) {
        long ans = ar[x]; int indx = x;
        int n = ar.length;
        for (int i = x + 1; i < n; i++){
            if (ans > ar[i]) {
                ans = ar[i];
                indx = i;
            }
        }
        return indx;
    }
}
