package Algorithms.Implementation;

import AritificialIntelligence.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class AppleOrange {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int s = in.readInt();
            int t = in.readInt();
            int a = in.readInt();
            int b = in.readInt();
            int m = in.readInt();
            int n = in.readInt();
            int apple = 0;
            int orange = 0;
            for (int i = 0; i < m; i++) {
                int p = in.readInt();
                int fc = a + p;
                if (fc >= s && fc <= t) {
                    apple++;
                }
            }
            for (int i = 0; i < n; i++) {
                int p = in.readInt();
                int fc = b + p;
                if (fc >= s && fc <= t) {
                    orange++;
                }
            }
            System.out.println(apple);
            System.out.println(orange);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
