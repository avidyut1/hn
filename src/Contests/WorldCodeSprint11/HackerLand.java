package Contests.WorldCodeSprint11;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 28/05/17
 **/
public class HackerLand {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int m = in.readInt();
            Vector<Vector<Integer>> g = new Vector<Vector<Integer>>();
            for (int i = 0; i < n; i++) {
                g.add(new Vector<Integer>());
            }
            for (int i = 0; i < m; i++) {
                int u = in.readInt() - 1;
                int v = in.readInt() - 1;
                g.get(u).add(v);
            }
            int qc = in.readInt();
            for (int q = 0; q < qc; q++) {
                int op = in.readInt();
                if (op == 1) {
                    int x = in.readInt() - 1;
                    int d = in.readInt();
                    if(d == 1) {
                        g.add(new Vector<Integer>());
                        g.get(g.size() - 1).add(x);
                    }
                    else {
                        g.add(new Vector<Integer>());
                        g.get(x).add(g.size() - 1);
                    }
                }
                else {
                    int x = in.readInt() - 1;
                    int y = in.readInt() - 1;
                    boolean vis[] = new boolean[g.size()];
                    dfs(vis, x, g);
                    if (vis[y]) {
                        out.write("Yes");
                    }
                    else {
                        out.write("No");
                    }
                    out.newLine();
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void dfs(boolean v[], int x, Vector<Vector<Integer>> g) {
        if (v[x]) {
            return;
        }
        v[x] = true;
        for (int ch: g.get(x)) {
            if (!v[ch]) {
                dfs(v, ch, g);
            }
        }
    }
}
