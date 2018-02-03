package Algorithms.DynamicProgramming;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;

public class Candies {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int r[] = new int[n];
            final int max = (int)1e5 + 1;
            Vector<Integer> index[] = new Vector[max];
            for (int i = 0; i < max; i++) {
                index[i] = new Vector<Integer>();
            }
            for (int i = 0; i < n; i++) {
                r[i] = in.readInt();
                index[r[i]].add(i);
            }
            int c[] = new int[n];
            Arrays.fill(c, 1);
            for (int i = 0; i < max; i++) {
                for(int ind: index[i]){
                    if(ind + 1 < n && r[ind + 1] > r[ind]){
                        if(c[ind + 1] <= c[ind]){
                            c[ind + 1] = c[ind] + 1;
                        }
                    }
                    if(ind - 1 >= 0 && r[ind - 1] > r[ind]){
                        if(c[ind - 1] <= c[ind]){
                            c[ind - 1] = c[ind] + 1;
                        }
                    }
                }
            }
            long sum = 0l;
            for (int i = 0; i < n; i++) {
                sum += c[i];
            }
            out.write(Long.toString(sum));
            out.newLine();out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

