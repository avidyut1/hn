package Algorithms.Greedy;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class Pylons {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int k = in.readInt();
            int ar[] = new int[n];
            Vector<IndexLight> v = new Vector<>();
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
                if (ar[i] == 1) {
                    v.add(new IndexLight(i, false));
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                boolean found = false;
                for (int j = 0; j < v.size(); j++) {
                    if (Math.abs(v.get(j).index - i) < k) {
                        if (v.get(j).on) {
                            found = true;
                            break;
                        }
                    }
                }
                if (found){
                    continue;
                }
                //we have to switch on some light
                //we will switch on the one which is fartherst
                int dist = Integer.MIN_VALUE;
                for (int j = v.size() - 1; j >= 0; j--) {
                    if (Math.abs(v.get(j).index - i) < k) {
                        if (Math.abs(v.get(j).index - i) > dist && !v.get(j).on) {
                            dist = Math.abs(v.get(j).index - i);
                        }
                    }
                }
                int ind = -1;
                for (int j = v.size() - 1; j >= 0; j--) {
                    if (Math.abs(v.get(j).index - i) == dist) {
                        ind = j;
                        break;
                    }
                }
                if (ind == -1) {
                    System.out.println(-1);
                    return;
                }
                v.get(ind).on = true;
                ans++;
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class IndexLight{
    int index;
    boolean on;
    public IndexLight(int i, boolean o) {
        this.index = i;
        this.on = o;
    }
}
