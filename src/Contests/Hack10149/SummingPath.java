package Contests.Hack10149;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 23/05/17
 **/
public class SummingPath {
    public static long ans;
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            boolean redBlackFlag[] = new boolean[n];
            for (int i = 0; i < n; i++) {
                redBlackFlag[i] = in.readInt() == 0;
            }
            ans = 0L;
            Vector<Edge> g[] = new Vector[n];
            for (int i = 0; i < n; i++) {
                g[i] = new Vector<>();
            }
            for (int i = 0; i < n - 1; i++) {
                int u = in.readInt() - 1;
                int v = in.readInt() - 1;
                int cost = in.readInt();
                g[u].add(new Edge(v, cost));
                g[v].add(new Edge(u, cost));
            }
            for (int i = 0; i < n; i++) {
                if (redBlackFlag[i]) {
                    boolean vis[] = new boolean[n];
                    dfsVisit(i, redBlackFlag, g, vis, 0);
                }
            }
            out.write(Long.toString(ans));
            out.newLine();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void dfsVisit(int vertex, boolean colFlag[], Vector<Edge> g[], boolean vis[], long c) {
        vis[vertex] = true;
        if (!colFlag[vertex])
            ans += c;
        for (Edge ch: g[vertex]) {
            if (!vis[ch.to])
                dfsVisit(ch.to, colFlag, g, vis, c + ch.cost);
        }
    }
}
class Edge{
    public int to, cost;
    public Edge(int t, int c) {
        this.to = t;
        this.cost = c;
    }
}
