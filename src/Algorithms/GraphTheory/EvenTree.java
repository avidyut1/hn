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
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int dfs(int v, Vector<Integer> g[]) {
        vis[v] = true;
        int num_nodes_in_subtree = 0;
        for(int child:  g[v]) {
            if (!vis[child]) {
                int num_node = dfs(child, g);
                if (num_node % 2 == 0) {
                    ans++;
                }
                else {
                    num_nodes_in_subtree += num_node;
                }
            }
        }
        return num_nodes_in_subtree + 1;
    }
}
