package Algorithms.Strings;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class CeasarCipher {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            char c[] =  (in.readLine()).toCharArray();
            int k = in.readInt();
            k %= 26;
            String alphac = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String alphas = "abcdefghijklmnopqrstuvwxyz";
            for (int i = 0; i < n; i++) {
                char ch = c[i];
                if (alphac.indexOf(ch) >= 0) {
                    int ascii = (int) ch + k;
                    if (ascii > 90) {
                        ascii -= 26;
                    }
                    System.out.print((char) ascii);
                }
                else if(alphas.indexOf(ch) >= 0) {
                    int ascii = (int) ch + k;
                    if (ascii > 122) {
                        ascii -= 26;
                    }
                    System.out.print((char) ascii);
                }
                else{
                    System.out.print(ch);
                }
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
