package Algorithms.DynamicProgramming;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class StringReduction {
    public static String min;
    public static int minl = Integer.MAX_VALUE;
    public static boolean stop = false;
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                minl = Integer.MAX_VALUE;
                stop = false;
                min = "";
                String s = in.readLine();
                solve(s.trim());
                System.out.println(min.length());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void solve(String s) {
        if (s.length() < minl) {
            minl = s.length();
            min = s;
            if (minl == 1) {
                stop = true;
                return;
            }
            if (minl == 2 && s.charAt(0) == s.charAt(1)) {
                stop = true;
                return;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                String ns = s.substring(0, i);
                ns += getOther(s.charAt(i), s.charAt(i + 1));
                ns += s.substring(i + 2);
                if (!stop)
                    solve(ns);
            }
        }
    }
    public static char getOther(char a, char b) {
        if ((a == 'a' && b == 'b') || (a == 'b' && b == 'a')) {
            return 'c';
        }
        else if ((a == 'a' && b == 'c') || (a == 'c' && b == 'a')) {
            return 'b';
        }
        else
            return 'a';
    }
}
