package Contests.Codeagon;

import java.io.*;
import java.util.*;
import java.math.*;

public class AnotherKnapsack {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int m = in.readInt();
            int set[] = new int[n];
            for (int i = 0; i < n; i++) {
                set[i] = i+1;
            }
            long sum = (long)((n * (n + 1)) / 2);
            if(sum < m){
                out.write(Integer.toString(-1));
                out.close();return;
            }
            out.newLine();out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


