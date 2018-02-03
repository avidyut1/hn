package Algorithms.Implementation;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class Acmicpcteam {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int m = in.readInt();
            int ar[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                char c[] = in.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    ar[i][j] = c[j] - '0';
                }
            }
            Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
            int mx = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int far[] = new int[m];
                    for (int k = 0; k < m; k++) {
                        far[k] = ar[i][k] + ar[j][k];
                        if(far[k] == 2) {
                            far[k] = 1;
                        }
                    }
                    int sum = 0;
                    for (int k = 0; k < m; k++) {
                        sum += far[k];
                    }
                    if (sum > mx) {
                        mx = sum;
                    }
                    hm.put(sum, hm.containsKey(sum) ? hm.get(sum) + 1: 1);
                }
            }
            out.write(Integer.toString(mx));
            out.newLine();
            out.write(Integer.toString(hm.get(mx)));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
