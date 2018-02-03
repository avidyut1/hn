package Algorithms.Greedy;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class GreedyFlorist {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int k = in.readInt();
            Integer c[] = new Integer[n];
            for (int i = 0; i < n; i++) {
                c[i] = in.readInt();
            }
            Arrays.sort(c, Collections.reverseOrder());
            Queue<Integer> pq = new PriorityQueue<Integer>();
            for (int i = 0; i < k; i++) {
                pq.add(0);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int customer = pq.poll();
                ans += (customer + 1) * c[i];
                pq.add(customer + 1);
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
