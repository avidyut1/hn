package Contests.Week27;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class DrawingBook {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int p = in.readInt();
            int front[] = new int[n + 1];
            int page = 0;
            for (int i = 1; i < n + 1; i++) {
                if (i % 2 == 0) {
                    page++;
                }
                front[i] = page;
            }
            page = 0;
            int back[] = new int[n + 1];
            for (int i = n; i >= 1; i--) {
                back[i] = page;
                if (i % 2 == 0) {
                    page++;
                }
            }
            out.write(Integer.toString(Math.min(front[p], back[p])));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
