package Algorithms.Greedy;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class PriyankaToys {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            Arrays.sort(ar);
            int unit = 1;
            int range = ar[0] + 4;
            for (int i = 0; i < n; i++) {
                if (ar[i] <= range) {
                    continue;
                }
                unit++;
                range = ar[i] + 4;
            }
            System.out.println(unit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
