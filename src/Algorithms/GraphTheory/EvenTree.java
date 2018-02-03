package Algorithms.GraphTheory;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class EvenTree {
    static int ans = 0;
    static boolean vis[] = new boolean[101];

    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int m = in.readInt();
            Vector<Integer> g[] = new Vector[n];
            for (int i = 0; i < n; i++) {
                g[i] = new Vector<Integer>();
            }
            for (int i = 0; i < m; i++) {
                int u = in.readInt() - 1;
                int v = in.readInt() - 1;
                g[u].add(v);
                g[v].add(u);
            }
            dfs(0, g);
            out.write(Integer.toString(ans));
            out.newLine();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void dfs(int v, Vector<Integer> g[]) {
        dfsVisit(new boolean[g.length], v, g);
    }
    private static int dfsVisit(boolean v[], int ch, Vector<Integer> g[]) {
        v[ch] = true;
        int nodes = 0;
        for (int ele: g[ch]) {
            if (!v[ele]) {
                int numNodes = dfsVisit(v, ele, g);
                if (numNodes % 2 == 0) {
                    ans++;
                }
                else {
                    nodes += numNodes;
                }
            }
        }
        return nodes + 1;
    }
}
