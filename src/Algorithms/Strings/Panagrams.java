package Algorithms.Strings;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class Panagrams {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            char s[] = (in.readLine()).toCharArray();
            int c[] = new int[26];
            String low_alpha = "abcdefghijklmnopqrstuvwxyz";
            for (int i = 0; i < s.length; i++) {
                if (low_alpha.indexOf(s[i]) < 0) {
                    s[i] = Character.toLowerCase(s[i]);
                }
            }
            for (int i = 0; i < s.length; i++) {
                if (low_alpha.indexOf(s[i]) >= 0)
                    c[s[i] - 'a']++;
            }
            String ans = "panagram";
            for (int i = 0; i < 26; i++) {
                if (c[i] == 0) {
                    ans = "not panagram";
                    break;
                }
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
