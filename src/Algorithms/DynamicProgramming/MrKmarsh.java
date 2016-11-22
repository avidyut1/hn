package Algorithms.DynamicProgramming;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class MrKmarsh {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int m = in.readInt();
            int n = in.readInt();
            char ar[][] = new char[m][n];
            for (int i = 0; i < m; i++) {
                ar[i] = (in.readLine()).toCharArray();
            }
            int ans = -1;
            int left[][] = new int[m][n];
            for (int i = 0; i < m; i++) {
                left[i][0] = ar[i][0] == '.' ? 0 : -1;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if(ar[i][j] == '.'){
                        left[i][j] = left[i][j - 1] + 1;
                    }
                    else{
                        left[i][j] = -1;
                    }
                }
            }
            int up[][] = new int[m][n];
            for (int i = 0; i < n; i++) {
                up[0][i] = ar[0][i] == '.' ? 0 : -1;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if(ar[j][i] == '.'){
                        up[j][i] = up[j - 1][i] + 1;
                    }
                    else
                        up[j][i] = -1;
                }
            }
            for (int r1 = 0; r1 < m; r1++) {
                for (int r2 = r1 + 1; r2 < m; r2++) {
                    Vector<Integer> possiblecols = new Vector<Integer>();
                    int rowdiff = r2 - r1;
                    for (int i = 0; i < n; i++) {
                        if(up[r2][i] >= rowdiff){
                            possiblecols.add(i);
                        }
                    }
                    int lefcolind = 0;
                    for(int col : possiblecols){
                        //find min left
                        int mincolleft = col - Math.min(left[r1][col], left[r2][col]);
                        //choosing the column which is possible
                        while(possiblecols.get(lefcolind) < mincolleft){
                            lefcolind++;
                        }
                        if(col > possiblecols.get(lefcolind)){
                            ans = Math.max(ans, 2 * (rowdiff) + 2 * (col - possiblecols.get(lefcolind)));
                        }
                    }
                }
            }
            if(ans == -1){
                out.write("Impossible");
            }
            else{
                out.write(Integer.toString(ans));
            }
            out.newLine();out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

