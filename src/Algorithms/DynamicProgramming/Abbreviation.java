package Algorithms.DynamicProgramming;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class Abbreviation {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int q = in.readInt();
            for (int qc = 0; qc < q; qc++) {
                char a[] = (in.readLine()).toCharArray();
                char b[] = (in.readLine()).toCharArray();
                boolean gans = true;
                String alpha = "abcdefghijklmnopqrstuvwxyz";
                boolean vis[] = new boolean[a.length];
                for (int i = 0; i < b.length; i++) {
                    boolean ans = false;
                    for (int j = 0; j < a.length; j++) {
                        if (vis[j]) {
                            continue;
                        }
                        if (a[j] == b[i]) {
                            vis[j] = true;
                            ans = true;
                            break;
                        }
                    }
                    if (!ans) {
                        for (int j = 0; j < a.length; j++) {
                            if (vis[j]) {
                                continue;
                            }
                            if (Character.toUpperCase(a[j]) == b[i]) {
                                vis[j] = true;
                                ans = true;
                                break;
                            }
                        }
                    }
                    if (!ans) {
                        gans = false;
                    }
                }
                if (gans) {
                    for (int i = 0; i < a.length; i++) {
                        if (!vis[i]){
                            int ind = alpha.indexOf(a[i]);
                            if (ind < 0) {
                                gans = false;
                            }
                        }
                    }
                    if (gans)
                        System.out.println("YES");
                    else {
                        System.out.println("NO");
                    }
                }
                else {
                    System.out.println("NO");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
