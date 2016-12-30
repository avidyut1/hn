package Algorithms.GraphTheory;

import Algorithms.InputReader;

import javax.xml.soap.Node;
import java.io.*;
import java.util.*;
import java.math.*;

public class BeautifulPath {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int m = in.readInt();
            Vector<EdgeBP> g[] = new Vector[n];
            for (int i = 0; i < n; i++) {
                g[i] = new Vector<EdgeBP>();
            }
            for (int i = 0; i < m; i++) {
                int u = in.readInt() - 1;
                int v = in.readInt() - 1;
                int c = in.readInt();
                g[u].add(new EdgeBP(v, c));
                g[v].add(new EdgeBP(u, c));
            }
            int a = in.readInt() - 1;
            int b = in.readInt() - 1;
            int ans = -1;
            boolean res[][] = new boolean[n][1024];
            Queue<NodeCost> q = new LinkedList<>();
            q.add(new NodeCost(a, 0));
            while(!q.isEmpty()) {
                NodeCost nc = q.poll();
                res[nc.n][nc.c] = true;
                for(EdgeBP ed : g[nc.n]) {
                    if (!res[ed.to][nc.c | ed.cost]) {
                        res[ed.to][nc.c | ed.cost] = true;
                        q.add(new NodeCost(ed.to, nc.c | ed.cost));
                    }
                }
            }
            for (int i = 0; i < res[b].length; i++) {
                if (res[b][i]) {
                    ans = i;break;
                }
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class EdgeBP{
    int to, cost;
    public EdgeBP(int t, int c){
        this.to = t;
        this.cost = c;
    }
}
class NodeCost{
    int n, c;
    public NodeCost(int n, int c) {
        this.n = n;
        this.c = c;
    }
}
