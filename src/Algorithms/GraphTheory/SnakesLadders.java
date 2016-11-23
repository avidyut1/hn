package Algorithms.ladderTheory;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class SnakesLadders {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                HashMap<Integer, Integer> gotonext = new HashMap<Integer, Integer>();
                for (int i = 0; i <= 100; i++) {
                    gotonext.put(i, i);
                }
                for (int i = 0; i < n; i++) {
                    int f = in.readInt();
                    int s = in.readInt();
                    gotonext.put(f, s);
                }
                int m = in.readInt();
                for (int i = 0; i < m; i++) {
                    int f = in.readInt();
                    int s = in.readInt();
                    gotonext.put(f, s);
                }
                int dist[] = new int[101];
                dist[1] = 0;
                Queue<Integer> q = new LinkedList<Integer>();
                q.add(1);
                boolean vis[] = new boolean[101];
                vis[1] = true;
                while(!q.isEmpty()) {
                    int current_ind = q.poll();
                    for (int i = 1; i <= 6; i++) {
                        if (current_ind + i <= 100) {
                            int next = gotonext.get(current_ind + i);
                            if (next < 1 || next > 100 || vis[next]) {
                                continue;
                            }
                            vis[next] = true;
                            q.add(next);
                            dist[next] = dist[current_ind] + 1;
                        }
                    }
                }
                if (vis[100]) {
                    System.out.println(dist[100]);
                }
                else
                    System.out.println(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

