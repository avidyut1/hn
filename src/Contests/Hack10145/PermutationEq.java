package Contests.Hack10145;

import java.io.*;
import java.util.*;
import java.math.*;

public class PermutationEq {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt() - 1;
            }
            int ans[] = new int[n];
            for (int i = 0; i < n; i++) {
                ans[ar[ar[i]]] = i;
            }
            for (int i = 0; i < n; i++) {
                out.write(Integer.toString(ans[i] + 1));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
