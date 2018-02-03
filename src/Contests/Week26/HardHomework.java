package Contests.Week26;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class HardHomework {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            if (n % 3 == 0){
                double max = 3 * Math.sin(n / 3);
                System.out.printf("%.9f", max);
                return;
            }
            int val1 = n / 3;
            int val3 = n / 3;
            int val2 = n / 3;
            int rem = n - (val1 + val2 + val3);
            val1 += rem;
            double ans = Math.sin(val1) + Math.sin(val2) + Math.sin(val3);
            System.out.printf("%.9f", ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
