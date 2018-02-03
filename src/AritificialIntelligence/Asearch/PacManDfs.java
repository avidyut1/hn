package AritificialIntelligence.Asearch;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PacManDfs {
    static Vector<String> vs = new Vector<>();
    static void dfs(int r, int c, int pacman_r, int pacman_c, int food_r, int food_c, String [] grid){
        Vector<String> nv = new Vector<>();
        nv.add(pacman_r+" "+pacman_c);
        boolean v[][] = new boolean[r][c];
        v[pacman_r][pacman_c] = true;
        dfs_visit(r, c, nv, pacman_r - 1, pacman_c, food_r, food_c, grid, v);
        dfs_visit(r, c, nv, pacman_r + 1, pacman_c, food_r, food_c, grid, v);
        dfs_visit(r, c, nv, pacman_r, pacman_c - 1, food_r, food_c, grid, v);
        dfs_visit(r, c, nv, pacman_r, pacman_c + 1, food_r, food_c, grid, v);
    }
    static void dfs_visit(int r, int c, Vector<String> path, int x, int y, int dx, int dy, String []g, boolean v[][]) {
        if (x < 0 || y < 0 || x >= r || y >= c || g[x].charAt(y) == '%' || v[x][y]) {
            return;
        }
        if (g[x].charAt(y) == '.') {
            path.add(x+" "+y);
            vs = path;
            return;
        }
        path.add(x+" "+y);
        v[x][y] = true;
        dfs_visit(r, c, path, x - 1, y, dx, dy, g, v);
        dfs_visit(r, c, path, x + 1, y, dx, dy, g, v);
        dfs_visit(r, c, path, x, y - 1, dx, dy, g, v);
        dfs_visit(r, c, path, x, y + 1, dx, dy, g, v);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int pacman_r = in.nextInt();
        int pacman_c = in.nextInt();

        int food_r = in.nextInt();
        int food_c = in.nextInt();

        int r = in.nextInt();
        int c = in.nextInt();

        String grid[] = new String[r];

        for(int i = 0; i < r; i++) {
            grid[i] = in.next();
        }

        dfs( r, c, pacman_r, pacman_c, food_r, food_c, grid);
        System.out.println(vs.size());
        for (String v : vs) {
            System.out.println(v);
        }
    }
}
