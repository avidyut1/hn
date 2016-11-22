package Contests.Hack10143;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class MaxMin {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            Arrays.sort(ar);
            int ans = ar[n - 1] - ar[0];
            ans = Math.min(ans, ar[n - 1] - ar[1]);
            ans = Math.min(ans, ar[n - 2] - ar[0]);
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
