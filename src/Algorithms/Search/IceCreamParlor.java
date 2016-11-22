package Algorithms.Search;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class IceCreamParlor {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int t = in.readInt();
            for (int i = 0; i < t; i++) {
                int m = in.readInt();
                int n = in.readInt();
                int ar[] = new int[n];
                Vector<IndexVal> v = new Vector<IndexVal>();
                for (int j = 0; j < n; j++) {
                    ar[j] = in.readInt();
                    v.add(new IndexVal(j + 1, ar[j]));
                }
                Collections.sort(v);
                int var[] = new int[n]; System.arraycopy(ar, 0, var, 0, n);
                Arrays.sort(var);
                int ind1 = -1, ind2 = -1;
                for (int j = 0; j < n; j++) {
                    if(ar[j] <= m) {
                        int rem = m - ar[j];
                        int ind = Arrays.binarySearch(var, rem);
                        if (ind >= 0) {
                            int acind = v.get(ind).id;
                            if(acind != j + 1) {
                                ind1 = j + 1; ind2 = acind;
                                break;
                            }
                        }
                    }
                }
                System.out.println(Math.min(ind1, ind2)+" "+Math.max(ind1, ind2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class IndexVal implements Comparable<IndexVal>{
    int id, val;
    public IndexVal(int i, int v) {
        this.id = i;
        this.val = v;
    }
    @Override
    public int compareTo(IndexVal that){
        return this.val - that.val;
    }
}
