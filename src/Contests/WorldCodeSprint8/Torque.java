package Contests.WorldCodeSprint8;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class Torque {
    static Vector<Vector<Integer>> cc = new Vector<>();
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                cc.clear();
                int n = in.readInt();
                int m = in.readInt();
                int clib = in.readInt();
                int croad = in.readInt();
                Vector<Integer> g[] = new Vector[n];
                for (int i = 0; i < n; i++) {
                    g[i] = new Vector<>();
                }
                for (int i = 0; i < m; i++) {
                    int u = in.readInt() - 1;
                    int v = in.readInt() - 1;
                    g[u].add(v);
                    g[v].add(u);
                }
                dfs(g);
                long ans = (long)clib * n;
                long lans = 0l;
                for(Vector<Integer> component: cc) {
                    lans+= (long)clib + ((component.size() - 1) * croad);
                }
                System.out.println(Math.min(lans, ans));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void dfs(Vector <Integer> g[]) {
        int n = g.length;
        boolean v[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                cc.add(new Vector<Integer>());
                dfs_visit(i, g, v, cc.size() - 1);
            }
        }
    }
    public static void dfs_visit(int i, Vector<Integer> g[], boolean v[], int ind) {
        v[i] = true;
        cc.get(ind).add(i);
        for (int ch: g[i]) {
            if (!v[ch]) {
                dfs_visit(ch, g, v, ind);
            }
        }
    }
}
