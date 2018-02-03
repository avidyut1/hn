package Algorithms.Greedy;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class TwoArrays {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                int k = in.readInt();
                Vector<Integer> va = new Vector<Integer>();
                for (int i = 0; i < n; i++) {
                    va.add(in.readInt());
                }
                Vector<Integer> vb = new Vector<Integer>();
                for (int i = 0; i < n; i++) {
                    vb.add(in.readInt());
                }
                Collections.sort(va);
                Collections.sort(vb);
                int a[] = new int[n];
                int b[] = new int[n];
                boolean ans = true;
                for (int i = 0; i < va.size(); i++) {
                    int ele = va.get(i);
                    int rem = k - ele;
                    int ind = Collections.binarySearch(vb, rem);
                    if (ind < 0) {
                        ind = -1 - ind;
                    }
                    if (ind < vb.size()) {
                        b[i] = vb.get(ind);
                        a[i] = ele;
                        vb.remove(ind);
                    }
                    else {
                        ans = false;
                        break;
                    }
                }
//                System.out.println(Arrays.toString(a));
//                System.out.println(Arrays.toString(b));
                if (ans) {
                    System.out.println("YES");
                }
                else
                    System.out.println("NO");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
