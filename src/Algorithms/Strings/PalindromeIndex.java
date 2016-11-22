package Algorithms.Strings;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class PalindromeIndex {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                char car[] = in.readLine().toCharArray();
                int n = car.length;
                System.out.println(isPalinInd(car));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean isPalinRem(int i, char c[]) {
        int n = c.length;
        String s = new String(c);
        s = s.substring(0, i) + s.substring(i + 1);
        return isPalin(s.toCharArray());
    }
    public static boolean isPalin(char c[]) {
        int r = c.length % 2 == 0 ? c.length / 2 : c.length / 2 + 1;
        int j = c.length - 1;
        for (int i = 0; i < r; i++) {
            if (c[i] != c[j]) {
                return false;
            }
            j--;
        }
        return true;
    }
    public static int isPalinInd(char c[]) {
        int r = c.length % 2 == 0 ? c.length / 2 : c.length / 2 + 1;
        int j = c.length - 1;
        for (int i = 0; i < r; i++) {
            if (c[i] != c[j]) {
                if (isPalinRem(i, c)) {
                    return i;
                }
                if (isPalinRem(j, c)) {
                    return j;
                }
            }
            j--;
        }
        return -1;
    }
}
