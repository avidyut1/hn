package HackerRankHiring;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class ArraysAndQuery {
    public static void main(String args[]) {
        try {
            final int MOD = (int)1e9 + 7;
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            long ans = 0L;
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            for (int j = 0; j < ar.length; j++) {
                tm.put(ar[j], tm.containsKey(ar[j]) ? tm.get(ar[j]) + 1 : 1);
            }
            int q = in.readInt();
            long lansPrev = 0L;
            Vector<Integer> count = new Vector<>();
            for (int key: tm.keySet()) {
                count.add(tm.get(key));
                if (tm.containsKey(key + 1)) {
                    continue;
                }
                int min = Collections.min(count);
                lansPrev += min;
                for (int c: count) {
                    lansPrev += (c - min);
                }
                count.clear();
            }
            for (int i = 1; i <= q; i++) {
                int ind = in.readInt() - 1;
                int val = in.readInt();
                count = new Vector<>();
                int key = ar[ind];
                count.add(tm.get(key));
                for (int j = key + 1; ; j++) {
                    if(!tm.containsKey(j)) {
                        break;
                    }
                    count.add(tm.get(j));
                }
                for (int j = key - 1; ; j--) {
                    if(!tm.containsKey(j)) {
                        break;
                    }
                    count.add(tm.get(j));
                }
                int min = Collections.min(count);
                long lans = 0L;
                if (i - 1 > 0) {
                    lans -=  ((i - 1) * min);
                }
                else {
                    lans -= min;
                }
                for (int c: count) {
                    if (i - 1 > 0) {
                        lans -= ((i - 1) * (c - min));
                    }
                    else {
                        lans -= (c - min);
                    }
                }
                count.clear();
                if (tm.get(ar[ind]) == 1) {
                    tm.remove(ar[ind]);
                }
                else {
                    tm.put(ar[ind], tm.get(ar[ind]) - 1);
                }
                ar[ind] = val;
                key = ar[ind];
                tm.put(ar[ind], tm.containsKey(ar[ind]) ? tm.get(ar[ind]) + 1  : 1);
                count.add(tm.get(key));
                for (int j = key + 1; ; j++) {
                    if(!tm.containsKey(j)) {
                        break;
                    }
                    count.add(tm.get(j));
                }
                for (int j = key - 1; ; j--) {
                    if(!tm.containsKey(j)) {
                        break;
                    }
                    count.add(tm.get(j));
                }
                min = Collections.min(count);
                lans += i * min;
                for (int c: count) {
                    lans += (i) * (c - min);
                }
                if (i - 1 > 0) {
                    lans += ((lansPrev) / (i - 1)) * i;
                }
                else {
                    lans += lansPrev;
                }
                lansPrev = lans;
                ans = (lans) % MOD;
            }
            out.write(Long.toString(ans));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
