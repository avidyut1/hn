package Algorithms.Strings;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class FunnyString {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int i = 0; i < tc; i++) {
                StringBuffer sb = new StringBuffer(in.readLine());
                StringBuffer rev = new StringBuffer(sb);
                rev.reverse();
                char sar[] = sb.toString().toCharArray();
                char rar[] = rev.toString().toCharArray();
                boolean ans = true;
                for (int j = 1; j < sar.length - 1; j++) {
                    if (Math.abs(sar[j] - sar[j - 1]) != Math.abs(rar[j] - rar[j - 1])) {
                        ans = false;
                        break;
                    }
                }
                if (ans) {
                    System.out.println("Funny");
                }
                else
                    System.out.println("Not Funny");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
