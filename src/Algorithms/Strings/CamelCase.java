package Algorithms.Strings;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class CamelCase {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            String s = in.readLine();
            int words = 1;
            String alpha = "QWERTYUIOPLKAJHGSFDZXCVBNM";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int ind = alpha.indexOf(c);
                if (ind >= 0) {
                    words++;
                }
            }
            System.out.println(words);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
