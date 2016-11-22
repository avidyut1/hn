package Algorithms.Greedy;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class SherlockBeast {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int i = 0; i < tc; i++) {
                boolean ans = false;
                int n = in.readInt();
                int numfives = n / 3;
                for (int j = numfives * 3; j >= 0; j-=3) {
                    if ((n - j) % 5 == 0) {
                        ans = true;
                        for (int k = 0; k < j; k++) {
                            System.out.print("5");
                        }
                        for (int k = 0; k < n - j; k++) {
                            System.out.print("3");
                        }
                        System.out.println();
                        break;
                    }
                }
                if (!ans)
                    System.out.println("-1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
