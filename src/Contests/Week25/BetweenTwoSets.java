package Contests.Week25;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class BetweenTwoSets {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int m = in.readInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.readInt();
            }
            int b[] = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = in.readInt();
            }
            int sol = 0;
            for (int i = 2; i <= 100; i++) {
                boolean fx = true;
                for (int j = 0; j < n; j++) {
                    if(a[j] > i) {
                        fx = false;break;
                    }
                    if (i % a[j] != 0) {
                        fx = false;break;
                    }
                }
                boolean xf = true;
                for (int j = 0; j < m; j++) {
                    if (i > b[j]){
                        xf = false;break;
                    }
                    if (b[j] % i != 0)  {
                        xf = false;break;
                    }
                }
                if(fx && xf)
                    sol++;
            }
            System.out.println(sol);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
