package Algorithms.GraphTheory;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;
//TODO
public class JackRupture {
    public static int ans = Integer.MAX_VALUE;
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int m = in.readInt();
            Vector<E> g[] = new Vector[n];
            for (int i = 0; i < n; i++) {
                g[i] = new Vector<E>();
            }
            for (int i = 0; i < m; i++) {
                int f = in.readInt() - 1;
                int s = in.readInt() - 1;
                int w = in.readInt();
                g[f].add(new E(s, w));
                g[s].add(new E(f, w));
            }
            dfs(g);
            if (ans == Integer.MAX_VALUE) {
                System.out.println("NO PATH EXISTS");
            }
            else
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void dfs(Vector<E> g[]) {
        for(E ed: g[0]) {
            boolean v[] = new boolean[g.length];
            v[0] = true;
            dfs_visit(ed.to, 0, v, g, ed.w);
        }
    }
    public static void dfs_visit(int ver, int paid, boolean v[], Vector<E> g[], int cost) {
        if (v[ver])
            return;
        int c = cost - paid;
        if (c >= 0)
            paid += c;
        System.out.println(paid);
        System.out.println(ver);
        int n = g.length;
        if (ver == n - 1) {
            ans = Math.min(ans, paid);
            return;
        }
        v[ver] = true;
        for(E ed: g[ver]) {
            dfs_visit(ed.to, paid, v, g, ed.w);
        }
    }
}
class E{
    int to, w;
    public E(int to, int w) {
        this.to = to;
        this.w = w;
    }
}
