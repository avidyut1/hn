package Contests.HourOfCode2016;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class Thegreatrobery {
    static Vector<Integer> possibleans = new Vector<>();
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int m = in.readInt();
            int grid[][] = new int[n][m];
            int sy = in.readInt();
            int sx = in.readInt();
            int dy = in.readInt();
            int dx = in.readInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = in.readInt();
                }
            }
            int ans[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(ans[i], Integer.MAX_VALUE);
            }
            ans[sx][sy] = grid[sx][sy];
            Queue<Pair> pq = new LinkedList<>();
            pq.add(new Pair(sx, sy, ans[sx][sy]));
            while(!pq.isEmpty()) {
                Pair p = pq.poll();
                if (p.x < 0 || p.y < 0 || p.x >= grid.length || p.y >= grid[0].length) {
                    continue;
                }
                ans[p.x][p.y] = Math.min(grid[p.x][p.y], p.min);
                if (p.x == dx && p.y == dy) {
                    possibleans.add(p.min);
                    continue;
                }
                if (p.x + 1 < grid.length && ans[p.x + 1][p.y] > ans[p.x][p.y])
                    pq.add(new Pair(p.x + 1, p.y, ans[p.x][p.y]));
                if (p.x - 1 >= 0 && ans[p.x - 1][p.y] > ans[p.x][p.y])
                    pq.add(new Pair(p.x - 1, p.y, ans[p.x][p.y]));
                if (p.y + 1 < grid[0].length && ans[p.x][p.y + 1] > ans[p.x][p.y])
                    pq.add(new Pair(p.x, p.y + 1, ans[p.x][p.y]));
                if (p.y - 1 >= 0 && ans[p.x][p.y - 1] > ans[p.x][p.y])
                    pq.add(new Pair(p.x, p.y - 1, ans[p.x][p.y]));
            }
            int max = Integer.MIN_VALUE;
            for(int i: possibleans){
                max = Math.max(max, i);
            }
            System.out.println(max);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Pair{
    int x, y, min;
    public Pair(int x, int y, int min) {
        this.x = x;
        this.y = y;
        this.min = min;
    }
}
