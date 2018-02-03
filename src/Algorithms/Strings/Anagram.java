package Algorithms.Strings;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class Anagram {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                char a[] = (in.readLine()).toCharArray();
                if (a.length % 2 == 0) {
                    int ff [] = new int[26];
                    int fs [] = new int[26];
                    for (int i = 0; i < a.length / 2; i++) {
                        ff[a[i] - 'a']++;
                    }
                    for (int i = a.length / 2; i < a.length; i++) {
                        fs[a[i] - 'a']++;
                    }
                    int ans = 0;
                    for (int i = 0; i < 26; i++) {
                        if (ff[i] == fs[i]) {
                            continue;
                        }
                        if (ff[i] > fs[i]) {
                            ans += (ff[i] - fs[i]);
                        }
                        else {
                            ans += (fs[i] - ff[i]);
                        }
                    }
                    System.out.println(ans / 2);
                }
                else
                    System.out.println(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
