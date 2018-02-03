package Contests.Week26;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class StreetParade {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.readInt();
            }
            int m = in.readInt();
            int hmin = in.readInt();
            int hmax = in.readInt();
            int ans = a[0] - hmin;
            int stop = ans + m;
            for (int i = 1; i < n; i++) {
                if (stop >= a[i]) {
                    if (a[i] - a[i - 1] >= hmin && a[i] - a[i - 1] <= hmax) {
                        continue;
                    }
                    else {
                        ans = a[i] - hmin;
                        stop = ans + m;
                    }
                }
                else {
                    break;
                }
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
