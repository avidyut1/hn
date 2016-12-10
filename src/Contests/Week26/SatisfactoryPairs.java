package Contests.Week26;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class SatisfactoryPairs {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int ans = 0;
            for (int a = 1; a < n; a++) {
                for (int b = a + 1; b < n; b++) {
                    boolean lans = false;
                    for (int x = 1; x < n && !lans; x++) {
                        int y = (n - (a * x));
                        if (y > 0 && y % b == 0) {
                            ans++;
                            lans = true;
                            break;
                        }
                    }
                }
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
