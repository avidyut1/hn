package Algorithms.GraphTheory;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class TheGreatRobery {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int m = in.readInt();
            int sy = in.readInt();
            int sx = in.readInt();
            int ey = in.readInt();
            int ex = in.readInt();
            int ar[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ar[i][j] = in.readInt();
                }
            }
            int low = 1, high = (int)1e9 + 1;
            int ans = 0;
            while(low <= high) {
                int mid = (low + high) >> 1;
                if (check(mid, ar, sx, sy, ex, ey)) {
                    low = mid + 1;
                    ans = mid;
                }
                else {
                    high = mid - 1;
                }
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean check(int val, int ar[][], int sx, int sy, int ex, int ey) {
        Queue<Point> pq = new LinkedList<>();
        boolean v[][] = new boolean[ar.length][ar[0].length];
        pq.add(new Point(sx, sy));
        while(!pq.isEmpty()) {
            Point p = pq.poll();
            v[p.x][p.y] = true;
            if (p.x == ex && p.y == ey) {
                return true;
            }
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i + j) != 1)
                        continue;
                    int nx = p.x + i;
                    int ny = p.y + j;
                    if (nx < 0 || nx >= ar.length || ny < 0 || ny >= ar[0].length) {
                        continue;
                    }
                    if (ar[nx][ny] < val || v[nx][ny]) {
                        continue;
                    }
                    pq.add(new Point(nx, ny));
                }
            }
        }
        return false;
    }
}
class Point{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return this.x+" "+this.y;
    }
}
