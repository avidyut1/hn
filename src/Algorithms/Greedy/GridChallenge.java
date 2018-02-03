package Algorithms.Greedy;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class GridChallenge {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                char [][]grid = new char[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        grid[i][j] = in.readCharacter();
                    }
                }
                for (int i = 0; i < n; i++) {
                    Arrays.sort(grid[i]);
                }
                boolean ans = true;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (j + 1 < n && grid[j][i] - 'a' > grid[j + 1][i] - 'a') {
                            ans = false;
                            break;
                        }
                    }
                }
                if (ans) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
