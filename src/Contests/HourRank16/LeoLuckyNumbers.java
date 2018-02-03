package Contests.HourRank16;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class LeoLuckyNumbers {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            Set<Long> hs = new HashSet<>();
            Queue<Long> pq = new LinkedList<>();
            pq.add(4l);
            pq.add(7l);
            int count = 1;
            while(!pq.isEmpty()) {
                long val = pq.poll();
                hs.add(val);
                pq.add(val + 4);
                pq.add(val + 7);
                count++;
                if (count == 100000)
                    break;
            }
            System.out.println(hs);
            int q = in.readInt();
            for (int i = 0; i < q; i++) {
                long n = in.readLong();
                if (hs.contains(n)) {
                    out.write("Yes");
                }
                else {
                    out.write("No");
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
