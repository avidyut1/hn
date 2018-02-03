package Contests.Hack10144;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class PickingNumbers {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int count[] = new int[1001];
            for (int i = 0; i < n; i++) {
                count[in.readInt()]++;
            }
            int ans = 0;
            for (int i = 1; i < 101; i++) {
                ans = Math.max(ans, count[i] + count[i + 1]);
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
