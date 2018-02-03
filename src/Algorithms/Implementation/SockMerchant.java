package Algorithms.Implementation;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class SockMerchant {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int c[] = new int[101];
            for (int i = 0; i < n; i++) {
                c[in.readInt()]++;
            }
            int ans = 0;
            for (int i = 0; i < 101; i++) {
                ans += c[i] / 2;
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
