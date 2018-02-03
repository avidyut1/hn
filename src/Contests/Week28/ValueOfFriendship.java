package Contests.Week28;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class ValueOfFriendship {
    static long total = 0l;
    static Vector<Vector<Integer>> cc = new Vector<Vector<Integer>>();
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int q = in.readInt();
            for (int qc = 0; qc < q; qc++) {
                total = 0;
                cc.clear();
                Set<Edge> edges = new HashSet<>();
                int n = in.readInt();
                int m = in.readInt();
                Vector<Integer> g[] = new Vector[n];
                for (int i = 0; i < n; i++) {
                    g[i] = new Vector<>();
                }
                for (int i = 0; i < m; i++) {
                    int u = in.readInt() - 1;
                    int v = in.readInt() - 1;
                    g[u].add(v);
                    g[v].add(u);
                    edges.add(new Edge(u, v));
                }
                for (int i = 0; i < n; i++) {
                    Collections.sort(g[i]);
                }
                dfs(g, edges);
                out.write(Long.toString(total));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void dfs(Vector<Integer> g[], Set<Edge> se) {
        boolean vis[] = new boolean[g.length];
        int n = g.length;
        Node ar[] = new Node[n];
        for (int i = 0; i < n; i++) {
            ar[i] = new Node(i, g[i].size());
        }
        Arrays.sort(ar);
        for (int i = n - 1; i >= 0; i--) {
            if (!vis[ar[i].id]) {
                cc.add(new Vector<Integer>());
                dfsVisit(-1, g, ar[i].id, vis, se);
            }
        }
    }
    public static void dfsVisit(int prev, Vector<Integer> g[], int ver, boolean v[], Set<Edge> se) {
        if (v[ver]) {
            if (se.contains(new Edge(prev, ver))) {
                if (cc.get(cc.size() - 1).size() > 1) {
                    for(Vector<Integer> c : cc) {
                        total += (c.size() * (c.size() - 1));
                    }
                }
            }
            return;
        }
        v[ver] = true;
        cc.get(cc.size() - 1).add(ver);
        if (se.contains(new Edge(prev, ver))) {
            if (cc.get(cc.size() - 1).size() > 1) {
                for(Vector<Integer> c : cc) {
                    total += (c.size() * (c.size() - 1));
                }
            }
        }
        for (int ch: g[ver]) {
            dfsVisit(ver, g, ch, v, se);
        }
    }
}
class Edge{
    int f, to;
    public Edge(int f, int t) {
        this.f = f;
        this.to = t;
    }
    public boolean equals(Object ob) {
        Edge that = (Edge)ob;
        if (that.f == this.f && this.to == that.to) {
            return true;
        }
        return false;
    }
    public int hashCode(){
        return this.f * 1000000 + this.to;
    }
}
class Node implements Comparable<Node>{
    public int id, countedges;
    public Node(int id, int countedges) {
        this.id = id;
        this.countedges = countedges;
    }
    public int compareTo(Node that) {
        return this.countedges - that.countedges;
    }
}