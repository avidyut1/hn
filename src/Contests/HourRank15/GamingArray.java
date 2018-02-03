package Contests.HourRank15;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class GamingArray {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                Queue<IndexVal> pq = new PriorityQueue<>(1000000, new IndexVal());
                for (int i = 0; i < n; i++) {
                    pq.add(new IndexVal(i, in.readInt()));
                }
                int count = 0;
                int goneindafter = n;
                while(!pq.isEmpty()) {
                    IndexVal iv = pq.poll();
                    if (iv.index >= goneindafter) {
                        continue;
                    }
                    goneindafter = iv.index;
                    count++;
                }
                if (count % 2 != 0) {
                    System.out.println("BOB");
                }
                else
                    System.out.println("ANDY");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class IndexVal implements Comparator<IndexVal> {
    int index, val;
    public IndexVal(){}
    public IndexVal(int i, int v) {
        this.index = i;
        this.val = v;
    }
    @Override
    public int compare(IndexVal f, IndexVal s) {
        if(f.val > s.val) {
            return -1;
        }
        else
            return 1;
    }
}
