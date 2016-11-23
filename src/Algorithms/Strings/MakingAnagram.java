package Algorithms.Strings;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class MakingAnagram {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            char f[] = in.readLine().toCharArray();
            char s[] = in.readLine().toCharArray();
            int freqf[] = new int[26];
            int freqs[] = new int[26];
            for (int i = 0; i < f.length; i++) {
                freqf[f[i] - 'a']++;
            }
            for (int i = 0; i < s.length; i++) {
                freqs[s[i] - 'a']++;
            }
            int ans = 0;
            for (int i = 0; i < 26; i++) {
                ans += Math.max(freqf[i], freqs[i]) - Math.min(freqf[i], freqs[i]);
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
