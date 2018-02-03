package Contests.Hack10145;

import java.io.*;
import java.util.*;
import java.math.*;

public class MinimumEdgesLayer {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int k = in.readInt();
            if (k > n) {
                out.write(Integer.toString(-1));
                out.newLine();
            }
            else {
                if (k == n) {
                    out.write(Integer.toString(n - 1));
                    out.newLine();
                }
                else {
                    int graph[] = new int[k];
                    int used = 0;
                    for (int i = 0; i < k; i++) {
                        if (i == k - 2)
                            continue;
                        graph[i] = 1;
                        used++;
                    }
                    int rem = n - used;
                    if (rem <= 0) {
                        out.write(Integer.toString(-1));
                        out.newLine();
                    }
                    else {
                        for (int i = 0; i < rem; i++) {
                            graph[k - 2]++;
                        }
                        if (graph[0] == graph[k - 1] && graph[0] == 1) {
                            int edgecount = 0;
                            for (int i = 1; i < k; i++) {
                                edgecount += (graph[i] * graph[i - 1]);
                            }
                            out.write(Integer.toString(edgecount));
                            out.newLine();
                        }
                        else {
                            out.write(Integer.toString(-1));
                            out.newLine();
                        }
                    }
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
