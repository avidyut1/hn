package Contests.Week27;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class CoprimePaths {
    static Vector<Vector<Integer>> paths = new Vector<>();
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            final int MAX = (int)1e7 + 1;
            boolean isprime[] = new boolean[MAX];
            Arrays.fill(isprime, true);
            Vector<Integer> primes = new Vector<>();
            isprime[0] = false;
            isprime[1] = false;
            for (int i = 0; i < MAX; i++) {
                if (isprime[i]) {
                    for (int j = 2 * i; j < MAX; j+=i) {
                        isprime[j] = false;
                    }
                }
            }
            for (int i = 0; i < MAX; i++) {
                if(isprime[i]) {
                    primes.add(i);
                }
            }
            int n = in.readInt();
            int q = in.readInt();
            int nv[] = new int[n];
            for (int i = 0; i < n; i++) {
                nv[i] = in.readInt();
            }
            BitSet b[] = new BitSet[n];
            for (int i = 0; i < n; i++) {
                b[i] = new BitSet(primes.size());
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < primes.size(); j++) {
                    if (nv[i] % primes.get(j) == 0) {
                        b[i].set(j);
                    }
                }
            }
            Vector<Integer> g[] = new Vector[n];
            for (int i = 0; i < n; i++) {
                g[i] = new Vector<>();
            }
            for (int i = 0; i < n - 1; i++) {
                int u = in.readInt() - 1;
                int v = in.readInt() - 1;
                g[u].add(v);
                g[v].add(u);
            }
            for (int i = 0; i < q; i++) {
                paths.clear();
                int f = in.readInt() - 1;
                int t = in.readInt() - 1;
                dfs(f, t, g);
                int ans = 0;
                if (paths.size() > 0) {
                    Vector<Integer> path = paths.get(0);
                    for (int j = 0; j < path.size(); j++) {
                        for (int k = j + 1; k < path.size(); k++) {
                            boolean common = false;
                            if (b[path.get(j)].intersects(b[path.get(k)])){
                                common = true;
                            }
                            if (!common) {
                                ans++;
                            }
                        }
                    }
                }
                out.write(Integer.toString(ans));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void dfs(int f, int t, Vector<Integer> g[]) {
        boolean v[] = new boolean[g.length];
        for(int ch: g[f]) {
            Vector<Integer> path = new Vector<>();
            v[f] = true;
            path.add(f);
            dfs_visit(ch, v, f, t, g, path);
        }
    }
    public static void dfs_visit(int ver, boolean v[], int f, int t, Vector<Integer>g[], Vector<Integer> path) {
        if (ver == t) {
            path.add(ver);
            paths.add(path);
            return;
        }
        if (v[ver]) {
            return;
        }
        v[ver] = true;
        Vector<Integer> newpath = new Vector<>(path);
        newpath.add(ver);
        for(int ch: g[ver]) {
            if (!v[ch]) {
                dfs_visit(ch, v, f, t, g, newpath);
            }
        }
    }
}
