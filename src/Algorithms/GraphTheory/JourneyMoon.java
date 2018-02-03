package Algorithms.GraphTheory;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class JourneyMoon {
    static Vector<Vector<Integer>> cc = new Vector<Vector<Integer>>();
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int m = in.readInt();
            Vector<Integer> g[] = new Vector[n];
            for (int i = 0; i < n; i++) {
                g[i] = new Vector<Integer>();
            }
            for (int i = 0; i < m; i++) {
                int u = in.readInt();
                int v = in.readInt();
                g[u].add(v);
                g[v].add(u);
            }
            dfs(g);
            int size[] = new int[cc.size()];
            for (int i = 0; i < cc.size(); i++) {
                size[i] = cc.get(i).size();
            }
            n = size.length;
            long sum = 0l;
            for (int i = 0; i < size.length; i++) {
                for (int j = i + 1; j < n; j++) {
                    sum += (size[i] * size[j]);
                }
            }
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void dfs(Vector<Integer> g[]) {
        boolean v[] = new boolean[g.length];
        for (int i = 0; i < g.length; i++) {
            if (!v[i]){
                cc.add(new Vector<Integer>());
                dfs_visit(i, g, v, cc.size() - 1);
            }
        }
    }
    public static void dfs_visit(int ver, Vector<Integer> g[], boolean v[], int indc) {
        if (v[ver])
            return;
        cc.get(indc).add(ver);
        v[ver] = true;
        for (int ad: g[ver]) {
            dfs_visit(ad, g, v, indc);
        }
    }
}
