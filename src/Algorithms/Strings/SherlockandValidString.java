package Algorithms.Strings;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class SherlockandValidString {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            String s = in.readLine();
            int freq[] = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }
            String ans = "YES";
            int f = freq[0];
            for (int i = 0; i < 26; i++) {
                if (freq[i] == 0) {
                    continue;
                }
                if (freq[i] != f) {
                    ans = "NO";
                }
            }
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    freq[i]--;
                    //all same
                    int ffrq = freq[0];
                    boolean lans = true;
                    for (int j = 0; j < 26; j++) {
                        if (freq[j] == 0)
                            continue;
                        if (ffrq != freq[j]) {
                            lans = false;
                            break;
                        }
                    }
                    if(lans) {
                        ans = "YES";
                        break;
                    }
                    else {
                        freq[i]++;
                    }
                }
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
