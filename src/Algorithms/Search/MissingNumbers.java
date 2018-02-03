package Algorithms.Search;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class MissingNumbers {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            final int MAX = (int)1e5 + 1;
            int n = in.readInt();
            int freqa[] = new int[MAX];
            for (int i = 0; i < n; i++) {
                freqa[in.readInt()]++;
            }
            int m = in.readInt();
            int freqb[] = new int[MAX];
            for (int i = 0; i < m; i++) {
                freqb[in.readInt()]++;
            }
            for (int i = 0; i < MAX; i++) {
                if (freqb[i] > freqa[i]) {
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
