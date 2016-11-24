package Algorithms.Strings;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class TwoStrings {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int t = in.readInt();
            for (int i = 0; i < t; i++) {
                String f = in.readLine();
                String s = in.readLine();
                String alpha = "abcdefghijklmnopqrstuvwxyz";
                boolean ans = false;
                for (int j = 0; j < 26; j++) {
                    if (f.indexOf(alpha.charAt(j)) >= 0 && s.indexOf(alpha.charAt(j)) >= 0) {
                        ans = true;
                    }
                }
                if (ans) {
                    System.out.println("YES");
                }
                else
                    System.out.println("NO");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
