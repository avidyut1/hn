package Algorithms.GraphTheory;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class SynchronousShopping {
    public static void main(String args[]) {
        try {
            int INF = (int)1e9;
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int m = in.readInt();
            int k = in.readInt();
            int mask[] = new int[n];
            for (int i = 0; i < n; i++) {
                int t = in.readInt();
                for (int j = 0; j < t; j++) {
                    int x = in.readInt() - 1;
                    mask[i] |= (1 << x);
                }
            }
            Vector<EdgeSS> graph[] = new Vector[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new Vector<>();
            }
            int dist[][] = new int[n][1 << k];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], INF);
            }
            for (int i = 0; i < m; i++) {
                int u = in.readInt() - 1;
                int v = in.readInt() - 1;
                int cost = in.readInt();
                graph[u].add(new EdgeSS(v, cost));
                graph[v].add(new EdgeSS(u, cost));
            }
            dist[0][mask[0]] = 0;
            Queue<IndexVal> pq = new PriorityQueue<IndexVal>(1000000, new Comparator<IndexVal>() {
                @Override
                public int compare(IndexVal o1, IndexVal o2) {
                    return Integer.compare(o1.dist, o2.dist);
                }
            });
            boolean vis[][] = new boolean[n][1 << k];
            pq.add(new IndexVal(0, new VertexMask(0, mask[0])));
            while(!pq.isEmpty()) {
                IndexVal indexVal = pq.poll();
                int maskIV = indexVal.vertexMask.mask;
                int vertexIV = indexVal.vertexMask.vertex;
                int distIV = indexVal.dist;
                if (vis[vertexIV][maskIV]) {
                    continue;
                }
                vis[vertexIV][maskIV] = true;
                for (EdgeSS edgeSS: graph[vertexIV]) {
                    int newMask = mask[edgeSS.to] | maskIV;
                    if (dist[edgeSS.to][newMask] > distIV + edgeSS.cost) {
                        dist[edgeSS.to][newMask] = distIV + edgeSS.cost;
                        pq.add(new IndexVal(dist[edgeSS.to][newMask], new VertexMask(edgeSS.to, newMask)));
                    }
                }
            }
            int ans = INF;
            for (int i = 0; i < 1 << k; i++) {
                for (int j = 0; j < 1 << k; j++) {
                    if ((i | j) == ((1 << k) - 1)) {
                        ans = Math.min(ans, Math.max(dist[n - 1][i], dist[n - 1][j]));
                    }
                }
            }
            out.write(Integer.toString(ans));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class EdgeSS {
        public int to, cost;

        public EdgeSS(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    private static class IndexVal{
        int dist;
        VertexMask vertexMask;

        public IndexVal(int dist, VertexMask vertexMask) {
            this.dist = dist;
            this.vertexMask = vertexMask;
        }
    }

    private static class VertexMask {
        public int vertex;
        public int mask;

        public VertexMask(int vertex, int mask) {
            this.vertex = vertex;
            this.mask = mask;
        }
    }
}
