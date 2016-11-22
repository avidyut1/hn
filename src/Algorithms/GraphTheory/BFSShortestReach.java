package Algorithms.GraphTheory;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class BFSShortestReach {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int q = in.readInt();
            for (int qc = 0; qc < q; qc++) {
                int n = in.readInt();
                int m = in.readInt();
                Vector<Integer> graph[] = new Vector[n];
                for (int i = 0; i < n; i++) {
                    graph[i] = new Vector<Integer>();
                }
                for (int i = 0; i < m; i++) {
                    int u = in.readInt() - 1;
                    int v = in.readInt() - 1;
                    graph[u].add(v);
                    graph[v].add(u);
                }
                int dist[] = new int[n];
                int s = in.readInt() - 1;
                Arrays.fill(dist, Integer.MAX_VALUE);
                dist[s] = 0;
                Queue<DistKey> pq = new PriorityQueue<DistKey>(1000000, new DistKey());
                pq.add(new DistKey(0, s));
                boolean v[] = new boolean[n];
                while(!pq.isEmpty()) {
                    DistKey dk = pq.poll();
                    if (v[dk.k]) {
                        continue;
                    }
                    v[dk.k] = true;
                    for (int ver : graph[dk.k]) {
                        if (dist[ver] > dk.d + 6) {
                            dist[ver] = dk.d + 6;
                            pq.add(new DistKey(dist[ver], ver));
                        }
                    }
                }
                for (int i = 0; i < dist.length; i++) {
                    if (dist[i] == 0){
                        continue;
                    }
                    if (dist[i] == Integer.MAX_VALUE) {
                        System.out.print("-1 ");
                    }
                    else {
                        System.out.print(dist[i]+" ");
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class DistKey implements Comparator<DistKey> {
    int d, k;
    public DistKey(){

    }
    public DistKey(int d, int k) {
        this.d = d;
        this.k = k;
    }
    @Override
    public int compare(DistKey a, DistKey b) {
        return a.d - b.d;
    }

}
