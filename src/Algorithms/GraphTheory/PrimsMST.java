package Algorithms.GraphTheory;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class PrimsMST {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            Vector<Edge> g[] = new Vector[n];
            for (int i = 0; i < n; i++) {
                g[i] = new Vector<Edge>();
            }
            int m = in.readInt();
            for (int i = 0; i < m; i++) {
                int u = in.readInt() - 1;
                int v = in.readInt() - 1;
                int w = in.readInt();
                g[u].add(new Edge(u, v, w));
                g[v].add(new Edge(v, u, w));
            }
            int s = in.readInt() - 1;
            int dist[] = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            boolean v[] = new boolean[n];
            Queue<KeyDist> q = new PriorityQueue(10000000, new KeyDist());
            q.add(new KeyDist(s, 0));
            dist[s] = 0;
            while(!q.isEmpty()) {
                KeyDist kd = q.poll();
                if (v[kd.k]) {
                    continue;
                }
                v[kd.k] = true;
                for (Edge e: g[kd.k]) {
                    if (!v[e.to] && dist[e.to] > e.weight) {
                        dist[e.to] = e.weight;
                        q.add(new KeyDist(e.to, dist[e.to]));
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i < dist.length; i++) {
                sum += dist[i];
            }
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class KeyDist implements Comparator<KeyDist>{
    int k, d;
    public KeyDist(){

    }
    public KeyDist(int k, int d) {
        this.k = k;
        this.d = d;
    }
    @Override
    public int compare(KeyDist k, KeyDist d) {
        return k.d - d.d;
    }
}
class Edge{
    int from, to, weight;
    public Edge(int f, int t, int w) {
        this.from = f;
        this.to = t;
        this.weight = w;
    }
}
