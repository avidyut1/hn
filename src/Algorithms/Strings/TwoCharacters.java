package Algorithms.Strings;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class TwoCharacters {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            char s[] = (in.readLine()).toCharArray();
            int ans = 0;
            char alpha[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
            for (int i = 0; i < alpha.length; i++) {
                for (int j = 0; j < alpha.length ; j++) {
                    if (i == j)
                        continue;
                    char c1 = alpha[i];
                    char c2 = alpha[j];
                    int len = 0;
                    boolean f = true;
                    for (int k = 0; k < s.length; k++) {
                        if (f) {
                            if (s[k] == c1) {
                                len++;
                                f = !f;
                            }
                            if (s[k] == c2) {
                                len = 0;
                                break;
                            }
                        }
                        else {
                            if (s[k] == c2) {
                                len++;
                                f = !f;
                            }
                            if (s[k] == c1) {
                                len = 0;
                                break;
                            }
                        }
                    }
                    if (len > 1) {
                        ans = Math.max(ans, len);
                    }
                }
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
