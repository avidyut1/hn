package Algorithms.GraphTheory;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class SimilarPair {
    public static BIT bob;
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int t = in.readInt();
            Vector<Integer> tree[] = new Vector[n + 1];
            for (int i = 0; i < n + 1; i++) {
                tree[i] = new Vector<Integer>();
            }
            BitSet nodechild = new BitSet(n + 1);
            for (int i = 0; i < n - 1; i++) {
                int p = in.readInt();
                int c = in.readInt();
                tree[p].add(c);
                nodechild.set(c);
            }
            int root = -1;
            for (int i = 1; i < n + 1; i++) {
                boolean b = nodechild.get(i);
                if(!b){
                    root = i;
                    break;
                }
            }
            long ans = dfs(root, tree, t);
            out.write(Long.toString(ans));
            out.newLine();out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static long dfs(int r, Vector t[], int T){
        bob = new BIT(t.length);
        return dfs_visit(r, t, T);
    }
    public static long dfs_visit(int n, Vector t[], int T){
        long ans = 0l;
        int l = n - T; int r = n + T;
        if(l <= 0){
            l = 1;
        }
        if(r >= t.length){
            r = t.length - 1;
        }
        long lans = bob.query(l, r);
        ans += lans;
        bob.update(n, 1);
        Vector<Integer> chv = t[n];
        for(int ch: chv){
            ans += dfs_visit(ch, t, T);
        }
        bob.update(n, 0);
        return ans;
    }
}
class BIT{
    int ar[];
    int bit[];
    public BIT(int n){
        ar = new int[n];
        bit = new int[n];
    }
    public void update(int ind, int v){
        int diff = v - ar[ind];
        ar[ind] = v;
        for (int i = ind; i < ar.length; i+=(i & -i)) {
            bit[i] += diff;
        }
    }
    public long cumulative(int ind){
        int ans = 0;
        for (int i = ind; i > 0; i-=(i & -i)) {
            ans += bit[i];
        }
        return ans;
    }
    public long query(int l, int r){
        if(l - 1 <= 0){
            return cumulative(r);
        }
        return cumulative(r) - cumulative(l - 1);
    }
}