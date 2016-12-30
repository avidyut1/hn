package Contests.WorldCodeSprint8;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class ClimbingLeaderboard {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            Set<Integer> hs = new HashSet<>();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
                hs.add(ar[i]);
            }
            Vector<Integer> vec = new Vector<>();
            for(int ele: hs) {
                vec.add(ele);
            }
            Collections.sort(vec);
            int m = in.readInt();
            for (int i = 0; i < m; i++) {
                int sc = in.readInt();
                int ind = Collections.binarySearch(vec, sc);
                if (ind < 0) {
                    ind = -1 -ind;
                    System.out.println(vec.size() - ind + 1);
                }
                else{
                    System.out.println(vec.size() - ind);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
