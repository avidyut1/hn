package Algorithms.Strings;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class StringConstruction {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int t = in.readInt();
            for (int tc = 0; tc < t; tc++) {
                char c[] = (in.readLine()).toCharArray();
                int n = c.length;
                Set<Character> hs = new HashSet<Character>();
                int ans = 0;
                for (int i = 0; i < n; i++) {
                    char cs = c[i];
                    if (hs.contains(cs)) {
                        continue;
                    }
                    else {
                        ans++;
                        hs.add(cs);
                    }
                }
                System.out.println(ans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
