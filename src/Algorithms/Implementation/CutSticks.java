package Algorithms.Implementation;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class CutSticks {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            System.out.println(n);
            while(true) {
                int min = findMin(ar);
                if (min == Integer.MAX_VALUE) {
                    break;
                }
                for (int i = 0; i < n; i++) {
                    ar[i] -= min;
                }
                int ans = 0;
                for (int i = 0; i < n; i++) {
                    if (ar[i] > 0) {
                        ans++;
                    }
                }
                if (ans > 0)
                System.out.println(ans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int findMin(int ar[]) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > 0)
            min = Math.min(min, ar[i]);
        }
        return min;
    }
}
