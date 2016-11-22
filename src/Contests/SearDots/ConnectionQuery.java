package Contests.SearDots;

import java.io.*;
import java.util.*;
import java.math.*;
class SegmentTreeNode {
    int l, r;
    Set<Integer> num; int cc;
    SegmentTreeNode left, right;
    public SegmentTreeNode(int l, int r){
        this.l = l;
        this.r = r;
        num = new HashSet<Integer>();
        cc = 0;
        this.left = null;this.right = null;
    }
}
class SegmentTree{
    SegmentTreeNode root = null;
    int ar[];
    public SegmentTree(int ar[]) {
        this.root = buildTree(null, 0, ar.length - 1);
        this.ar = ar;
    }
    public SegmentTreeNode buildTree(SegmentTreeNode n, int l, int r) {
        if (n == null) {
            n = new SegmentTreeNode(l, r);
        }
        if (l == r) {
            n.num.add(ar[l]);
            n.cc = 1;
        }
        else if (l < r) {
            int mid = (l + r) / 2;
            n.left = buildTree(n.left, l, mid);
            n.right = buildTree(n.right, mid + 1, r);
            n.cc = n.left.cc;
            for (int val: n.left.num) {
                n.num.add(val);
            }
            for(int val: n.right.num) {
                if (n.num.contains(val + 1) || n.num.contains(val - 1)) {
                    n.num.add(val);
                }
                else {
                    n.cc++;
                    n.num.add(val);
                }
            }
        }
        return n;
    }
    public int query(int x, int y) {
        return queryCC(root, x, y);
    }
    public int queryCC(SegmentTreeNode n, int l, int r) {
        if (n == null) {
            return 0;
        }
        if (l <= n.l && r >= n.r) {
            return n.cc;
        }
        else if(l > n.r || r < n.l) {
            return 0;
        }
        queryCC(n.left, l, r);
        queryCC(n.right, l, r);
        return 9;
    }
}
public class ConnectionQuery {
    public static void main(String args[]) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            String nq[] = (in.readLine()).split(" ");
            int n = Integer.parseInt(nq[0]);
            int q = Integer.parseInt(nq[1]);
            String sar[] = (in.readLine()).split(" ");
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = Integer.parseInt(sar[i]);
            }
            for (int i = 0; i < q; i++) {
                String xy[] = (in.readLine()).split(" ");
                int x = Integer.parseInt(xy[0]) - 1;
                int y = Integer.parseInt(xy[1]) - 1;
                int nar[] = new int[y - x + 1];
                for (int j = 0; j < nar.length; j++) {
                    nar[j] = ar[x + j];
                }
                Arrays.sort(nar);
                int ans = 1;
                for (int j = 1; j < nar.length; j++) {
                    if (nar[j] == nar[j - 1] + 1){
                        continue;
                    }
                    else{
                        ans++;
                    }
                }
                System.out.println(ans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
