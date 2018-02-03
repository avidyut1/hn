package Algorithms.Search;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class GridLandMetro {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            Map<Integer, Vector<ColumnStartEnd>> hm = new HashMap<>();
            int n = in.readInt();
            int m = in.readInt();
            int k = in.readInt();
            long ans = (long)n * m;
            for (int i = 0; i < k; i++) {
                int r = in.readInt();
                int cols = in.readInt();
                int cole = in.readInt();
                if (hm.containsKey(r)) {
                    ans -= (cole - cols + 1);
                    Vector<ColumnStartEnd> v = hm.get(r);
                    for (ColumnStartEnd range: v) {
                        if (range.r < cols || range.l > cole) {
                            continue;
                        }
                        ans += countIntersectingCell(range, cole, cols);
                        if (cols < range.l) {
                            if (cole >= range.l) {
                                cole = range.l - 1;
                            }
                        }
                        else {
                            if (range.r >= cols) {
                                cols = range.r + 1;
                            }
                        }
                    }
                    hm.get(r).add(new ColumnStartEnd(cols, cole));
                }
                else {
                    Vector<ColumnStartEnd> v = new Vector<>();
                    v.add(new ColumnStartEnd(cols, cole));
                    hm.put(r, v);
                    ans -= (cole - cols + 1);
                }
            }
            out.write(Long.toString(ans));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int countIntersectingCell(ColumnStartEnd cs, int r, int l) {
        if (l < cs.l) {
            if (r <= cs.r) {
                return r - cs.l + 1;
            }
            else {
                return cs.r - cs.l + 1;
            }
        }
        else {
            if (cs.r <= r) {
                return cs.r - l + 1;
            }
            else {
                return r - l + 1;
            }
        }
    }
}
class ColumnStartEnd{
    public int l, r;
    public ColumnStartEnd(int l, int r) {
        this.l = l;
        this.r = r;
    }
}
