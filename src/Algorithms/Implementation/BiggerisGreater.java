package Algorithms.Implementation;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class BiggerisGreater {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                char s[] = (in.readLine()).toCharArray();
                int n = s.length;
                int k = -1, l = -1;
                for (int i = n - 1; i >= 0; i--) {
                    if (i + 1 < n && s[i] < s[i + 1]) {
                        k = i;break;
                    }
                }
                if (k == -1) {
                    System.out.println("no answer");
                    continue;
                }
                for (int i = n - 1; i > k; i--) {
                    if (s[k] < s[i]) {
                        l = i;break;
                    }
                }
                char temp = s[k];
                s[k] = s[l];
                s[l] = temp;
                char res[] = new char[n];
                for (int i = 0; i <= k; i++) {
                    res[i] = s[i];
                }
                int ind = n - 1;
                for (int i = k + 1; i < n; i++) {
                    res[i] = s[ind--];
                }
                System.out.println(new String(res));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
