package Algorithms.Strings;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class LoveLetterMystery {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                char s[] = (in.readLine()).toCharArray();
                int ar[] = new int[s.length];
                for (int i = 0; i < s.length; i++) {
                    ar[i] = s[i] - 'a';
                }
                int i = 0, j = s.length - 1;
                int ans = 0;
                while(i < j){
                    ans += Math.max(ar[j], ar[i]) - Math.min(ar[j], ar[i]);
                    i++;
                    j--;
                }
                System.out.println(ans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
