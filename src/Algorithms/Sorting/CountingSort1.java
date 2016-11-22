package Algorithms.Sorting;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class CountingSort1 {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int c[] = new int[100];
            for (int i = 0; i < n; i++) {
                c[in.readInt()]++;
            }
            for (int i = 0; i < c.length; i++) {
                System.out.print(c[i] + " ");
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
